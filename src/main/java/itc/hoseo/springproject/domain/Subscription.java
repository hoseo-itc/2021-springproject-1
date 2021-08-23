package itc.hoseo.springproject.domain;

import lombok.Data;

@Data
public class Subscription {

	private Integer hostNo;
	private Integer subscriberNO;
	private String subscription_date;

	private Member hostMember;

	public Subscription() {}
	public Subscription(Integer publisher_no, Integer user_no, String subscription_date) {
		this.hostNo = publisher_no;
		this.subscriberNO = user_no;
		this.subscription_date = subscription_date;
	}
	
	
}
