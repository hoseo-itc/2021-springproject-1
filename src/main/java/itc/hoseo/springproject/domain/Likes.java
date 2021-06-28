package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Likes {

	private Integer post_no;
	private Integer user_no;
	private Integer state;
	
	public Likes() {}
	
	public Likes(Integer post_no, Integer user_no, Integer state) {
		this.post_no = post_no;
		this.user_no = user_no;
		this.state = state;
	}
	
}
