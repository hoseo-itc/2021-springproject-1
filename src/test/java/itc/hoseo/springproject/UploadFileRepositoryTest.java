package itc.hoseo.springproject;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.domain.UploadFile;
import itc.hoseo.springproject.repository.MemberRepository;
import itc.hoseo.springproject.repository.PostRepository;
import itc.hoseo.springproject.repository.UploadFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Rollback(value = false)
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UploadFileRepositoryTest {

    @Autowired
    UploadFileRepository repository;

    @Test
    @Order(1)
    public void testSave(){
        UploadFile uf = UploadFile.builder()
                .originName("test")
                .encodeName("test")
                .postNo(1)
                .build();
        assertEquals(1, repository.save(uf).getNo());

    }

}
