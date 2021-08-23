package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.domain.UploadFile;
import itc.hoseo.springproject.repository.MemberRepository;
import itc.hoseo.springproject.repository.PostRepository;
import itc.hoseo.springproject.repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UploadFileRepository uploadFileRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Post> postList() {
        return postRepository.findAll().stream()
                .map(p ->{
                    p.setUploadPhotos(uploadFileRepository.findByPostNo(p.getNo()));
                    return p;
                })
                .collect(Collectors.toList());
    }



    public Post postDetail(int no) {
        Post post = postRepository.upview(no);
//        Post post = postRepository.findByNo(no);
        post.setUploadPhotos(uploadFileRepository.findByPostNo(no));
        return post;
    }

    public Post postUpload(Post post) {
        Post savedPost = postRepository.save(post.getPublisher(), post);
//        for(UploadFile uf : post.getUploadPhotos()){
//            uf.setPostNo(savedPost.getNo());
//            uploadFileRepository.save(uf);
//        }

        post.getUploadPhotos().stream()
                .forEach(uf -> {
                    uf.setPostNo(savedPost.getNo());
                    uploadFileRepository.save(uf);
                });
        return savedPost;
    }



}
