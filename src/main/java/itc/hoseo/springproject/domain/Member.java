package itc.hoseo.springproject.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Member {
	
	private Integer no;					// 인식번호
	private String id;					// 아이디
	private String name;				// 이름
	private String password;			// 페스워드
	private Integer user_mode;			// 유저 권한
	private Date join_date;				// 회원가입 날짜
	private Date last_login_date;		// 마지막 로그인 날짜
	private Date last_password_date;	// 마지막 페스워드 변경일

	private List<Subscription> Subscriptions;	// 구독 목록
	
	public Member() {}

	public Member(String id, String password){
		this.id = id;
		this.password = password;
	};

	public Member(String id, String password, String name){
		this.id = id;
		this.password = password;
		this.name = name;	};

	
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
