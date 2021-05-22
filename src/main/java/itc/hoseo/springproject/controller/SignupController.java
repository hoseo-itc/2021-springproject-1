package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupService;

    @GetMapping("/login/signup")
    public String signUp(){
        return "login/signUp";
    }

    @PostMapping("/login/signup")
    public String signupAction(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name){
        boolean flag = signupService.signup(id,password,name);
        if(flag){
            return "redirect:/";
        }
        else{
            return "redirect:/login/signup";
        }
    }
}
