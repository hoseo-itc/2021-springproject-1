package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignupController {

    @Autowired
    private SignupController signupController;

    @GetMapping("/login/signup")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/login/signup")
    public String signupAction(){
        return "redirect:/";
    }
}
