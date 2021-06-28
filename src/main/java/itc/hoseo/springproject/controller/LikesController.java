package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/post/detail/likes")
    public String likes(@RequestParam("postNo") String post_no, HttpSession session){
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }

        return "post/postDetail";
    }
}
