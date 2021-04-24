package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Post {
	
	private Integer no;
	private Integer publisher_no;
	private String upload_date;
	private String change_date;
	private String title;
	private String text;
	private Integer visible;
	
	public Post() {}
	
	public Post(Integer no, Integer publisher_no, String upload_date, String change_date, String title, String text,
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
