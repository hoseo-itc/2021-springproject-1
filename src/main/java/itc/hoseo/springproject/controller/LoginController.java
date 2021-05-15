package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginForm(){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String loginAction(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest session){
        loginService.login(id,password,session);
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String loginAction(HttpServletRequest session){
        loginService.logout(session);
        return "redirect:/";
    }
}
