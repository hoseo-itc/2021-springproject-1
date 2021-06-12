package itc.hoseo.springproject.repository;

import itc.hoseo.springproject.domain.Comments;
import itc.hoseo.springproject.domain.Post;

import java.util.List;

public interface CommentsRepository {
    public Comments save(Integer post_no, Comments comments);
    public List<Comments> findByPostNo(int post_no);
    public Comments findByNo(int no);
    public int countByNo(int no);
    public int countByPostNo(int no);
}
