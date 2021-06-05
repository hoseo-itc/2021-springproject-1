package itc.hoseo.springproject.repository.impl;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.domain.UploadFile;
import itc.hoseo.springproject.repository.PostRepository;
import itc.hoseo.springproject.repository.UploadFileRepository;
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
public class H2UploadFileRepository implements UploadFileRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public UploadFile save(UploadFile file) {
        String sql = "insert into UploadFile(post_no,origin_name,encode_name, visible) values(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, file.getPostNo());
                ps.setString(2, file.getOriginName());
                ps.setString(3, file.getEncodeName());
                ps.setBoolean(4, file.getVisible());

                return ps;
            }
        }, keyHolder);

        int postNo =  (int)keyHolder.getKeys().get("no");

        return findByNo(postNo);
    }

    @Override
    public List<UploadFile> findByPostNo(int postNo) {
        return template.query("select * from UploadFile where post_no = ?",
                new BeanPropertyRowMapper<UploadFile>(UploadFile.class), postNo);
    }

    @Override
    public UploadFile findByNo(int no) {
        return template.queryForObject("select * from UploadFile where no = ?",
                new BeanPropertyRowMapper<UploadFile>(UploadFile.class), no);
    }
}
