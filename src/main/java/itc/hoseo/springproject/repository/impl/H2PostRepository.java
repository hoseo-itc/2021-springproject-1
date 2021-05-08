package itc.hoseo.springproject.repository.impl;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class H2PostRepository implements PostRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Post save(Member member,Post post) {
        template.update("insert into post(no,publisher_no,title,text) values((" +
                        "select count(*)+1 from post" +
                        "),?,?,?)",
                member.getNo(), post.getTitle(), post.getText());
        return findByPno(member);
    }

    @Override
    public List<Post> findAll() {
        return template.query("select * from post",
                new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public Post findByPno(Member member) {
        return template.queryForObject("select * from post where publisher_no = ?",
                new BeanPropertyRowMapper<Post>(Post.class), member.getNo());
    }
}
