package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.repository.MemberRepository;
import itc.hoseo.springproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Post> postList() {
        return postRepository.findAll();
    }

    public Post postDetail(int no) {
        return postRepository.findByNo(no);
    }

    public Post postUpload(Post post) {
        return postRepository.save(post.getPublisher(), post);
    }

}
