package itc.hoseo.springproject.repository.impl;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.domain.Subscription;
import itc.hoseo.springproject.repository.SubscriptRepository;
import itc.hoseo.springproject.service.SubscriptService;
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
public class H2SubscriptRepository implements SubscriptRepository {

    @Autowired
    private JdbcTemplate template;



    @Override
    public int setSubscript(int hostNo, int subscriberNO) {
        if(!checkSubscript(hostNo,subscriberNO)){
            String sql = "insert into subscription(hostNo,subscriberNO) values(?,?)";

            return template.update(sql
                    ,hostNo,subscriberNO);
        }
        return 0;
    }

    @Override
    public int delSubscript(int hostNo, int subscriberNO) {
        if(checkSubscript(hostNo,subscriberNO)){
            String sql = "delete from subscription where hostNo=? and subscriberNO=?";

            return template.update(sql
                    ,hostNo,subscriberNO);
        }
        return 0;
    }

    @Override
    public boolean checkSubscript(int hostNo, int subscriberNO) {
        String sql = "select count(*) from Subscription where hostNo=? and subscriberNO=?";

        int check = template.queryForObject(sql,
                Integer.class, hostNo,subscriberNO);

        if(check>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Subscription> findSubscriptListById(String id){
        String sql="select * from Subscription where subscriberNO = (select no from member where id = ?)";

        List<Subscription> subscriptions = template.query(sql,
                new BeanPropertyRowMapper<Subscription>(Subscription.class), id);

        for(int i=0;i<subscriptions.size();i++){
            Subscription sub = subscriptions.get(i);
            sql = "select * from member where no = ?";

            sub.setHostMember(template.queryForObject(sql,
                    new BeanPropertyRowMapper<Member>(Member.class), sub.getHostNo()));
            subscriptions.set(i,sub);
        }

        return subscriptions;
    }



}
