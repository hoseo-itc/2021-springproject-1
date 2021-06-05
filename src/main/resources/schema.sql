create table Member(
	no NUMBER AUTO_INCREMENT primary key,
	id varchar2(20) not null unique,
	name varchar2(20) not null,
	password varchar2(20) not null,
	
	user_mode NUMBER not null default 10,
	
	join_date DATE default now(),
	last_login_date DATE,
	last_password_date DATE
);

create table Post(
	no int AUTO_INCREMENT,
	publisher_no number not null,
	upload_date date not null default now(),
	change_date date,
	title varchar2(30) not null,
	text text,
	visible number not null default 1
);

alter table Post add primary key(no);

create table Files(
	no number primary key,
	publisher_no number not null,
	post_no number not null,
	origin_name varchar2(255) not null,
	encode_name varchar2(255) not null,
	
	visible number not null
);

create table Likes(
	Post_no number not null,
	user_no number not null,
	state number not null,
	target number not null,
	
	CONSTRAINT Likes_PK PRIMARY KEY(Post_no, user_no)
);

create table Comments(
	no int primary key AUTO_INCREMENT,
	post_no number not null,
	target number,
	content text,
	
	update_date date,
	change_date date
);

create table Subscription (
	publisher_no number not null,
	user_no number not null,
	subscription_date date,
	
	CONSTRAINT Subscription_PK PRIMARY KEY(Publisher_no, user_no)
);