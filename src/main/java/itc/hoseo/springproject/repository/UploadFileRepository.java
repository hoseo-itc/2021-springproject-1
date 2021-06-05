package itc.hoseo.springproject.repository;

import itc.hoseo.springproject.domain.Member;
import itc.hoseo.springproject.domain.Post;
import itc.hoseo.springproject.domain.UploadFile;

import java.util.List;

public interface UploadFileRepository {
    public UploadFile save(UploadFile file);
    public List<UploadFile> findByPostNo(int postNo);
    public UploadFile findByNo(int no);
}
