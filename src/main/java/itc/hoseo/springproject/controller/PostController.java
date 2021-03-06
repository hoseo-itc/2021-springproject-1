package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Comments;
import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.repository.LikesRepository;
import itc.hoseo.springproject.repository.SubscriptRepository;
import itc.hoseo.springproject.service.CommentsService;
import itc.hoseo.springproject.domain.UploadFile;
import itc.hoseo.springproject.domain.dto.PostUploadDto;
import itc.hoseo.springproject.service.LikesService;
import itc.hoseo.springproject.service.PostService;
import itc.hoseo.springproject.service.SubscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private LikesService likesService;

    @Autowired
    private SubscriptService subscriptService;

    @Autowired
    private Environment env;

    @GetMapping("/post/list")
    public String post(Model model) {
        List<Post> postList = postService.postList();
        model.addAttribute("postList", postList);
        return "post/postList";
    }

    @GetMapping("/post/detail")
    public String postDetail(@RequestParam("no") String s_no, Model model, HttpSession session) {
        // ????????? ??? ????????????
        int no = Integer.parseInt(s_no);
        Post post = postService.postDetail(no);
        model.addAttribute("post", post);

        // ?????? ????????????
        List<Comments> commentsList = commentsService.commentsList(no);
        model.addAttribute("commentsList", commentsList);

        // ?????????/?????????
        int like_state = 0;
        model.addAttribute("like_state", like_state);

        // ?????? ??????
        if(session.getAttribute("user")!=null){
            model.addAttribute("subscriptFlag"
                    , subscriptService.checkSubscript(post.getPublisher_no(),((Member)session.getAttribute("user")).getNo()));
        }else{
            model.addAttribute("subscriptFlag",false);
        }

        return "post/postDetail";
    }

    @GetMapping("/post/upload")
    public String postUpload(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "post/postUpload";
    }

    @PostMapping("/post/list")
    public String postListAction() {
        return "redirect:/";
    }

    @PostMapping("/post/upload")
    public String Upload(PostUploadDto dto, HttpSession session) {
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }
        Member m = (Member) session.getAttribute("user");
        Post post = postService.postUpload(convert(dto, m));

        return "redirect:/post/detail?no=" + post.getNo() ;
    }

    private Post convert(PostUploadDto dto, Member member){
        Post post = new Post();
        post.setPublisher_no(member.getNo());
        post.setPublisher(member);
        post.setText(dto.getText());
        post.setTitle(dto.getTitle());

        if(dto.getFiles() != null){
            List<UploadFile> list = dto.getFiles().stream()
                    .filter(f -> {
                        return f.isEmpty() == false;
                    })
                    .map(f -> {
                        final String uploadDir = env.getProperty("app.uploaddir.photo");

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        String curtDate = sdf.format(new Date());

                        UploadFile uf = new UploadFile();
                        uf.setVisible(true);
                        uf.setOriginName(f.getOriginalFilename());

                        if(Files.exists(Paths.get(uploadDir,curtDate)) == false){
                            try {
                                Files.createDirectory(Paths.get(uploadDir,curtDate));
                            } catch (IOException e) {
                                throw new RuntimeException("???????????? ?????? ??????",e);
                            }
                        }

                        //?????? ???????????? ?????????
                        String encName = UUID.randomUUID().toString();
                        while(Files.exists(Paths.get(uploadDir, curtDate, encName))) {
                            encName = UUID.randomUUID().toString();
                        }
                        try {
                            f.transferTo(Paths.get(uploadDir, curtDate, encName));
                        } catch (IOException e) {
                            throw new RuntimeException("?????? ???????????? ?????? ??????", e);
                        }
                        uf.setEncodeName(curtDate + "/" + encName);
                        return uf;
                    })
                    .collect(Collectors.toList());
            post.setUploadPhotos(list);
        }
        return post;
    }

}
