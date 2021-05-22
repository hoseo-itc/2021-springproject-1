package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/list")
    public String post(){
        return "post/postList";
    }

    @PostMapping("/post/list")
    public String postListAction(){
        return "redirect:/";
    }
}
