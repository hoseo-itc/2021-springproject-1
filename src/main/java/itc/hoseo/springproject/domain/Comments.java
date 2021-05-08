package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Comments {

	private Integer no;
	private Integer post_no;
	private Integer target;
	private String content;
	private String update_date;
	private String change_date;
	
	public Comments() {}
	
	public Comments(Integer no, Integer post_no, Integer target, String content, String update_date,
			String change_date) {
		this.no = no;
		this.post_no = post_no;
		this.target = target;
		this.content = content;
		this.update_date = update_date;
		this.change_date = change_date;
	}
}
