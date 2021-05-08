package itc.hoseo.springproject.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Member {
	
	private Integer no;
	private String id;
	private String name;
	private String password;
	private Integer user_mode;
	private Date join_date;
	private Date last_login_date;
	private Date last_password_date;
	
	public Member() {}

	public Member(String id, String password){
		this.id = id;
		this.password = password;
	};

	public Member(String id, String password, String name){
		this.id = id;
		this.password = password;
		this.name = name;
	};

	
	public Member(Integer no, String id, String name, String password, Integer user_mode, Date join_date,
				  Date last_login_date, Date last_password_date) {
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
