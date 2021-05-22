package itc.hoseo.springproject.repository.impl;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class H2MemberRepository implements MemberRepository {

    @Autowired
    private JdbcTemplate template;


    @Override
    public Member save(Member member) {
        template.update("insert into member(id,name,password) values(?,?,?)",
                member.getId(), member.getName(), member.getPassword());
        return findById(member.getId());
    }

    @Override
    public Member findById(String id) {
        if(countById(id)==0){
            return null;
        }
        return template.queryForObject("select * from member where id = ?",
                new BeanPropertyRowMapper<Member>(Member.class), id);
    }

    @Override
    public int countById(String id) {
        return template.queryForObject("select count(*) from member where id = ?",
                Integer.class, id);
    }

    // 관리자 함수
    @Override
    public List<Member> findAll() {
        return template.query("select * from member",
                new BeanPropertyRowMapper<>(Member.class));
    }

    @Override
    public List<Member> findAllUser() {
        return template.query("select * from member where user_mode = 10",
                new BeanPropertyRowMapper<>(Member.class));
    }

    @Override
    public List<Member> findAllManager() {
        return template.query("select * from member where user_mode = 20",
                new BeanPropertyRowMapper<>(Member.class));
    }
}
