package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Files {
	
	private Integer no;
	private Integer publisher_no;
	private Integer post_no;
	private String origin_name;
	private String encode_name;
	private Integer visible;
	
	public Files() {}
	
	public Files(Integer no, Integer publisher_no, Integer post_no, String origin_name, String encode_name,
			Integer visible) {
		this.no = no;
		this.publisher_no = publisher_no;
		this.post_no = post_no;
		this.origin_name = origin_name;
		this.encode_name = encode_name;
		this.visible = visible;
	}
	
	
}
