package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Subscription;
import itc.hoseo.springproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member findById(String id){
        return memberRepository.findById(id);
    }

}
