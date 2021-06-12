package itc.hoseo.springproject.repository.impl;

import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class H2LikesRepository implements LikesRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int likes(int state) {
        state=1;
        return state;
    }

    @Override
    public int dislikes(int state) {
        state=2;
        return state;
    }

    @Override
    public int getStateByUser(int post_no,int user_no) {
        int state=template.queryForObject("select state from likes where post_no=? and user_no=?",
                Integer.class,post_no,user_no);

        return state; // 0: 결과 없음 , 1:좋아요, 2:싫어요
    }


}
