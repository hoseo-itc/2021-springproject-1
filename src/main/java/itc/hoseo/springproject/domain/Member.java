package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Member {
	
	private Integer no;
	private String id;
	private String name;
	private String password;
	private Integer user_mode;
	private String join_date;
	private String last_login_date;
	private String last_password_date;
	
	public Member() {}
	
	public Member(Integer no, String id, String name, String password, Integer user_mode, String join_date,
			String last_login_date, String last_password_date) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.password = password;
		this.user_mode = user_mode;
		this.join_date = join_date;
		this.last_login_date = last_login_date;
		this.last_password_date = last_password_date;
	}
	
	
}
