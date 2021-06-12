package itc.hoseo.springproject.service;

import itc.hoseo.springproject.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {

    @Autowired
    private LikesRepository likesRepository;

    public int getState(int post_no, int user_no){

        return 0;
    }
    public List<Integer> getLikeCount(int post_no){
        List<Integer> intL = null;


        return intL;
    }

    public int likes(int post_no,int user_no){
        return 0;
    }
}
