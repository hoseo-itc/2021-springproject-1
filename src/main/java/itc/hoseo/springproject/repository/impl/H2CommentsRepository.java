package itc.hoseo.springproject.repository.impl;

import itc.hoseo.springproject.domain.Comments;
import itc.hoseo.springproject.repository.CommentsRepository;
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
public class H2CommentsRepository implements CommentsRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Comments save(Integer post_no, Comments comments) {
        String sql = "insert into comments(post_no,content) values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, comments.getPost_no());
                ps.setString(2, comments.getContent());

                return ps;
            }
        }, keyHolder);

        int commentsNo =  (int)keyHolder.getKeys().get("no");

        return findByNo(commentsNo);
    }


    @Override
    public List<Comments> findByPostNo(int post_no) {
        return template.query("select * from comments where post_no = ?",
                new BeanPropertyRowMapper<>(Comments.class));
    }

    @Override
    public Comments findByNo(int no) {
        if(countByNo(no)==0){
            return null;
        }
        return template.queryForObject("select * from comments where no = ?",
                new BeanPropertyRowMapper<Comments>(Comments.class), no);
    }

    @Override
    public int countByNo(int no) {
        return template.queryForObject("select count(*) from comments where no = ?",
                Integer.class, no);
    }

}
