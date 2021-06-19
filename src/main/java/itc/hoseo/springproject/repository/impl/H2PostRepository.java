package itc.hoseo.springproject.repository.impl;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class H2PostRepository implements PostRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Post save(Member member,Post post) {
        String sql = "insert into post(publisher_no,title,text) values(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, member.getNo());
                ps.setString(2, post.getTitle());
                ps.setString(3, post.getText());

                return ps;
            }
        }, keyHolder);

        int postNo =  (int)keyHolder.getKeys().get("no");

        return findByNo(postNo);
    }

    @Override
    public List<Post> findAll() {
        return template.query("select * from post where visible = 1",
                new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public Post findByNo(int no) {
        if(countByNo(no)==0){
            return null;
        }
        return template.queryForObject("select * from post where no = ?",
                new BeanPropertyRowMapper<Post>(Post.class), no);
    }

    @Override
    public int countByNo(int no) {
        return template.queryForObject("select count(*) from post where no = ?",
                Integer.class, no);
    }

    @Override
    public Post upview(int no) {
        if(countByNo(no)==0){
            return null;
        }
        template.update("update post set views=(select views from post where no = ?) where no = ?",new Object[] {no,no});

        return template.queryForObject("select * from post where no = ?",
                new BeanPropertyRowMapper<Post>(Post.class), no);
    }

    @Override
    public Post findByPno(Member member) {
        return template.queryForObject("select * from post where publisher_no = ?",
                new BeanPropertyRowMapper<Post>(Post.class), member.getNo());
    }
}
