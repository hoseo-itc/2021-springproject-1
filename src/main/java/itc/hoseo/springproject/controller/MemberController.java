package itc.hoseo.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @RequestMapping("/main")
    public String mainForm(){
        return "main";
    }
	
}
