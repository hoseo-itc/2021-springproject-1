package itc.hoseo.springproject.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Post {
	
	private Integer no;
	private Integer publisher_no;
	private Date upload_date;
	private Date change_date;
	private String title;
	private String text;
	private Integer visible;
	private Member publisher;
	private List<Comments> Comments;
	private List<UploadFile> uploadPhotos = new ArrayList<>();
	private Integer views;

	public Post() {}

	public Post(Integer publisher_no,String title,String text){
		this.publisher_no=publisher_no;
		this.title=title;
		this.text=text;
	}

	public Post(Integer no, Integer publisher_no, Date upload_date, Date change_date, String title, String text,
			Integer visible) {
		this.no = no;
		this.publisher_no = publisher_no;
		this.upload_date = upload_date;
		this.change_date = change_date;
		this.title = title;
		this.text = text;
		this.visible = visible;
	}
	
	
}
