package itc.hoseo.springproject.repository;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;

import java.util.List;

public interface PostRepository {
    public Post save(Member member,Post post);
    public List<Post> findAll();
    public Post findByPno(Member member);
    public Post findByNo(int no);
    public int countByNo(int no);
    public Post upview(int no);
}
