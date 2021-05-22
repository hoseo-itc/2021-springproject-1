package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/list")
    public String post(Model model){
        List<Post> postList = postService.postList();
        model.addAttribute("postList",postList);
        return "post/postList";
    }

    @PostMapping("/post/list")
    public String postListAction(){
        return "redirect:/";
    }
}
