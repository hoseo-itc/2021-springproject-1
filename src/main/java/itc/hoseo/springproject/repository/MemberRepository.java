package itc.hoseo.springproject.repository;

import itc.hoseo.springproject.domain.Member;

import java.util.List;

public interface MemberRepository {
    // 유저 기능
    public Member save(Member member);
    public Member findById(String id);
    public int countById(String id);
    //public Member login(String id, String password);

    // 관리자 기능
    public List<Member> findAll();
    public List<Member> findAllUser();
    public List<Member> findAllManager();

    // public void clear();
}
