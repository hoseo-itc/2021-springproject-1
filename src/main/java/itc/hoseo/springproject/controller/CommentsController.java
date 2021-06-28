package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Comments;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/comments/upload")
    public String commentsUpload(HttpSession session){
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }
        return "post/postDetail";
    }


    @PostMapping("/comments/upload")
    public String commentUpload(@RequestParam("postNo") String postNo,Comments comments, HttpSession session){
        if(session.getAttribute("user") == null){
            return "redirect:/login";
        }
        int pn=Integer.parseInt(String.valueOf(postNo));
        comments.setPost_no(pn);
        commentsService.commentsUpload(comments);
        return "redirect:/post/detail?no="+postNo;
    }

}
