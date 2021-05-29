package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/")
    public String rootPage(){
        return "main";
    }
    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

	
}
