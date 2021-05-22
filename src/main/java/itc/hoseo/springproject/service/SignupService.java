package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(String id, String password, String name){

        Member findMember = memberRepository.findById(id);
        if(findMember==null){
            memberRepository.save(new Member(id, password, name));
            return true;
        }
        return false;
    }
}
