package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/list")
    public String post(Model model) {
        List<Post> postList = postService.postList();
        model.addAttribute("postList", postList);
        return "post/postList";
    }

    @GetMapping("/post/detail")
    public String postDetail(@RequestParam("no") String s_no, Model model) {
        int no = Integer.parseInt(s_no);
        Post post = postService.postDetail(no);
        model.addAttribute("post", post);
        return "post/postDetail";
    }

    @GetMapping("/post/upload")
    public String postUpload( HttpSession session) {
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }
        return "post/postUpload";
    }

    @PostMapping("/post/list")
    public String postListAction() {
        return "redirect:/";
    }

    @PostMapping("/post/upload")
    public String Upload(Post post, HttpSession session) {
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }
        Member m = (Member) session.getAttribute("user");
        post.setPublisher_no(m.getNo());
        post.setPublisher(m);
        postService.postUpload(post);
        return "redirect:/";
    }
}
