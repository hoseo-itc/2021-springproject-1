package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean login(String id, String password, HttpServletRequest request){
        Member findMember = memberRepository.findById(id);
        if(findMember == null) {
            throw new IllegalArgumentException("사용자가 존재하지 않습니다.");
        }

        boolean isMatched = findMember.getPassword().equals(password);
        if(isMatched){
            HttpSession session = request.getSession();
            session.setAttribute("user",findMember);
        }
        return isMatched;
    }

    public boolean logout(HttpServletRequest request){
        boolean flag = false;

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        if(session.getAttribute("user") == null){
            flag = true;
        }
        return flag;
    }

}
