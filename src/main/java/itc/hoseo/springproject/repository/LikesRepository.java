package itc.hoseo.springproject.repository;

public interface LikesRepository {

    public int likes(int state);
    public int dislikes(int state);
    public boolean findByNo(int post_no,int user_no);
}
