package itc.hoseo.springproject;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.repository.LikesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LikesTest {

    @Autowired
    LikesRepository likesRepository;

    @Test
    public void testGetState(){
        System.out.println(likesRepository.getStateByUser(1,1));

    }
}
