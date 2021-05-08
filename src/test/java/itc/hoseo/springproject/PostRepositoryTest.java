package itc.hoseo.springproject;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.repository.MemberRepository;
import itc.hoseo.springproject.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Rollback(value = false)
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRepositoryTest {

    @Autowired
    MemberRepository memrepo;
    @Autowired
    PostRepository porepo;

    @Test
    @Order(1)
    public void testSave(){
        log.info("TEST Order 1");
        assertEquals("yy",
                memrepo.save(new Member("test","1234","yy")).getName());
    }

    @Test
    @Order(2)
    public void test() {
        log.info("TEST Order 2");
        Member mem = memrepo.findById("test");
        String t = "제목";
        String s = "내용입니다!!!";
        Post po = new Post(mem.getNo(),t,s);
        Post savedPost = porepo.save(mem,po);

        assertEquals(savedPost.getNo(),1);
    }

    @Test
    @Order(3)
    public void testFind() {
        log.info("TEST Order 3");
        assertEquals(1,porepo.findAll().size());
    }

}
