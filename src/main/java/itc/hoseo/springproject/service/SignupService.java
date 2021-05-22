package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class SignupService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(){
        return false;
    }
}
