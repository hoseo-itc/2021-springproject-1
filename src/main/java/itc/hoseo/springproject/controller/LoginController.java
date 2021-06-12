package itc.hoseo.springproject.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import itc.hoseo.springproject.service.LoginService;




@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginForm(HttpServletRequest request){
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage", referer);
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String loginAction(HttpServletRequest request,@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest session){
        if(id.trim().equals("")||password.trim().equals("")){
            return "redirect:/login";
        }
        loginService.login(id,password,session);
        String prevPage = (String)request.getSession().getAttribute("prevPage");
        return "redirect:"+prevPage;
    }
    
    @GetMapping("/testprofile")
    public String testprofile(){
        return "testprofile";
    }
    

    @RequestMapping("/logout")
    public String loginAction(HttpServletRequest request){
        String referer = request.getHeader("Referer");
        loginService.logout(request);
        return "redirect:"+referer;
    }
    
    @GetMapping("/auth")
    //@ResponseBody
    public String kakaoCallback(String code, HttpSession session) throws JsonMappingException, JsonProcessingException {
    String accessToken = getKakaoAccessToken(code).toString();

    if (accessToken == null) {
    throw new RuntimeException("사용자 정보가 존재하지 않습니다.");
    }

    RestTemplate rt = new RestTemplate();
    HttpHeaders header = new HttpHeaders();
    header.add("Authorization", "Bearer " + accessToken);
    header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

    HttpEntity<MultiValueMap<String, Object>> restRequest = new HttpEntity<>(header);

    ResponseEntity<String> response = rt.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, restRequest,
    String.class);

    ObjectMapper om = new ObjectMapper();
    JsonNode node = om.readTree(response.getBody());
    String email = node.at("/kakao_account/email").textValue();
    String imgUrl = node.at("/kakao_account/profile/thumbnail_image_url").textValue();
    String nickName = node.at("/kakao_account/profile/nickname").textValue();
    //TODO :: 사용자 정보를 DB에 저장

    session.setAttribute("email", email);
    session.setAttribute("imgUrl", imgUrl);
    session.setAttribute("nickName", nickName);


    return "redirect:/testprofile";
    //return response.getBody();
    }

    public String getKakaoAccessToken(String code) {

    final String RequestUrl = "https://kauth.kakao.com/oauth/token"; // Host
    final List<NameValuePair> postParams = new ArrayList<NameValuePair>();

    postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
    postParams.add(new BasicNameValuePair("client_id", "25c3e04cd386ae486d59b8bdbf9a69aa")); // REST API KEY
    postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:8081/auth")); // 리다이렉트 URI
    postParams.add(new BasicNameValuePair("code", code)); // 로그인 과정중 얻은 code 값

    final HttpClient client = HttpClientBuilder.create().build();
    final HttpPost post = new HttpPost(RequestUrl);

    JsonNode returnNode = null;

    try {
    post.setEntity(new UrlEncodedFormEntity(postParams));

    final HttpResponse response = client.execute(post);
    final int responseCode = response.getStatusLine().getStatusCode();

    System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
    System.out.println("Post parameters : " + postParams);
    System.out.println("Response Code : " + responseCode);

    // JSON 형태 반환값 처리
    ObjectMapper mapper = new ObjectMapper();

    returnNode = mapper.readTree(response.getEntity().getContent());

    } catch (UnsupportedEncodingException e) {
    e.printStackTrace();
    } catch (ClientProtocolException e) {
    e.printStackTrace();
    } catch (IOException e) {
    e.printStackTrace();
    } finally {
    }

    return returnNode.get("access_token").asText();
    }
}
