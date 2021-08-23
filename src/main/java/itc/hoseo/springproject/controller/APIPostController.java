package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.service.SubscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class APIPostController {
    @Autowired
    SubscriptService subscriptService;

    @PostMapping("/subscript")
    public HashMap<String, Object> subscript(@RequestParam("hostNo") String hostNo, HttpSession session){
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Member member = (Member) session.getAttribute("user");

        boolean flag = subscriptService.setSubscript(Integer.parseInt(hostNo),member.getNo());

        if(flag){
            hashMap.put("state",true);
        }else{
            hashMap.put("state",false);
        }
        return hashMap;
    }

    @PostMapping("/delSubscript")
    public HashMap<String, Object> delSubscript(@RequestParam("hostNo") String hostNo, HttpSession session){
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Member member = (Member) session.getAttribute("user");

        boolean flag = subscriptService.delSubscript(Integer.parseInt(hostNo),member.getNo());

        if(flag){
            hashMap.put("state",true);
        }else{
            hashMap.put("state",false);
        }
        return hashMap;
    }
}
