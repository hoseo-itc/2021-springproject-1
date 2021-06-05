package itc.hoseo.springproject.service;

import itc.hoseo.springproject.domain.Comments;
import itc.hoseo.springproject.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public Comments commentsUpload(Comments comments) {
        return commentsRepository.save(comments.getPost_no(), comments);
    }

    public List<Comments> commentsList(int post_no) {
        return commentsRepository.findByPostNo(post_no);
    }
}
