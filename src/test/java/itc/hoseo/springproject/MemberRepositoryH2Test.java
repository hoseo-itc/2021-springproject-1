package itc.hoseo.springproject;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.repository.MemberRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberRepositoryH2Test {

    @Autowired
    MemberRepository repo;

    @Test
    @Order(1)
    public void testSave(){
        assertEquals("yy",
                repo.save(new Member("test","1234","yy")).getName());
    }

    @Test
    @Order(2)
    public void test() {
        assertEquals(1,repo.findAll().size());
    }

    @Test
    @Order(3)
    public void testId(){
        assertEquals("yy",repo.findById("test").getName());
    }
}
