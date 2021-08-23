create table Member(
	no NUMBER AUTO_INCREMENT primary key,   -- 멤버 인식번호
	id varchar2(20) not null unique,        -- 아이디
	name varchar2(20) not null,             -- 이름
	password varchar2(20) not null,         -- 비밀번호
	
	user_mode NUMBER not null default 10,   -- 유저권한 (10:일반,20:관리자)
	
	join_date DATE default now(),           -- 가입날짜
	last_login_date DATE,                   -- 미지막 로그인 날짜
	last_password_date DATE                 -- 마지막 페스워드 변경일
);

create table Post(
	no int AUTO_INCREMENT,                  -- 게시글 번호
	publisher_no number not null,           -- 게시글 등록자 번호
	upload_date datetime not null default now(),    -- 업로드 날짜
	change_date datetime,                   -- 수정 날자
	title varchar2(30) not null,            -- 제목
	text text,                              -- 내용
	visible boolean not null default true,      -- 일반 멤버에게 보이기 여부(true:보임,false:안보임)
	views int default 0                     -- 조회수
);

alter table Post add primary key(no);

create table UploadFile(
	no int AUTO_INCREMENT primary key,      -- 파일 번호
	post_no number not null,                -- 파일과 짝이되는 포스트 번호
	origin_name varchar2(255) not null,     -- 원 파일명
	encode_name varchar2(255) not null,     -- 서버에 저장되는 파일명
	visible boolean not null  default true  -- 일반 멤버에게 보이기 여부(true:보임,false:안보임)
);

create table Likes(
	Post_no number not null,        -- 대상 게시물 번호
	user_no number not null,        -- 멤버 번호(좋아요,싫어요 주체)
	state number not null,          -- 좋아요 싫어요(0:싫어요,1:좋아요)
	--target number not null,
	
	CONSTRAINT Likes_PK PRIMARY KEY(Post_no, user_no)
);

create table Comments(
	no int primary key AUTO_INCREMENT,  -- 댓글번호
	post_no number not null,            -- 대상 게시물 번호
	target number,
	content text,                       -- 댓글 내용
	
	update_date date default now(),     -- 댓글 작성일자
	change_date date                    -- 댓글 수정일자
);

create table Subscription (
	hostNo number not null,         -- 구독 대상자 (피구독자)
	subscriberNO number not null,   -- 구독자 (구독주체)
	subscription_date date default now(),         -- 구독 날짜
	
	CONSTRAINT Subscription_PK PRIMARY KEY(hostNo, subscriberNO)
);