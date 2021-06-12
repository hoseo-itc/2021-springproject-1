package itc.hoseo.springproject.service;

import itc.hoseo.springproject.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {

    @Autowired
    private LikesRepository likesRepository;

    public int likes(int post_no,int user_no){
        return 0;
    }
}
