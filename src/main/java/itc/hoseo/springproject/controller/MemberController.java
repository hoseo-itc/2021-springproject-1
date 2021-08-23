package itc.hoseo.springproject.controller;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.service.LoginService;
import itc.hoseo.springproject.service.MemberService;
import itc.hoseo.springproject.service.SubscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private MemberService memberService;

    @Autowired
    private SubscriptService subscriptService;

    @GetMapping("/member/detail")
    public String memberDetail(HttpSession session, Model model){

        String id = ((Member)session.getAttribute("user")).getId();

        Member findMember = memberService.findById(id);


        findMember.setSubscriptions(subscriptService.findSubscriptListById(id));

        // 구독 여부
        if(findMember.getSubscriptions().isEmpty()){
            model.addAttribute("subscriptFlag", false);
        }else{
            model.addAttribute("subscriptFlag", true);
        }

        model.addAttribute("userProfile", findMember);

        return "member/memberDetail";
    }


}
