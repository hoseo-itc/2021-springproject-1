package itc.hoseo.springproject;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.repository.MemberRepository;
import itc.hoseo.springproject.repository.PostRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Rollback(value = false)
public class PostRepositoryTest {

    @Autowired
    MemberRepository memrepo;
    @Autowired
    PostRepository porepo;

    @Test
    @Order(1)
    public void testSave(){
        assertEquals("yy",
                memrepo.save(new Member("test","1234","yy")).getName());
    }

    @Test
    @Order(2)
    public void test() {
        Member mem = memrepo.findById("test");
        String t = "제목";
        String s = "내용입니다!!!";
        Post po = new Post(mem.getNo(),t,s);
        Post savedPost = porepo.save(mem,po);

        //assertEquals(savedPost.getTitle(),t);
    }

    //@Test
    //@Order(3)
    public void testId(){
        //assertEquals("yy",porepo.findByPno(1));
    }
}
