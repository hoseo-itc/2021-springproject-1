package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Subscription {

	private Integer publisher_no;
	private Integer user_no;
	private String subscription_date;
	
	public Subscription() {}
	
	public Subscription(Integer publisher_no, Integer user_no, String subscription_date) {
		this.publisher_no = publisher_no;
		this.user_no = user_no;
		this.subscription_date = subscription_date;
	}
	
	
}
