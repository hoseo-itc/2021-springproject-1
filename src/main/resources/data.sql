-- noinspection SqlNoDataSourceInspectionForFile

-- 메니저 계정
insert into Member(id,name,password,user_mode)
values ('manager1','매니저1','q1w2e3r4',20);

insert into Member(id,name,password,user_mode)
values ('manager2','매니저2','q1w2e3r4',20);

insert into Member(id,name,password,user_mode)
values ('manager3','매니저3','q1w2e3r4',20);

-- 유저계정
insert into Member(id,name,password,user_mode)
values ('testuser1','테스터1','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser2','테스터2','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser3','테스터3','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser4','테스터4','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser5','테스터5','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser6','테스터6','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser7','테스터7','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser8','테스터8','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser9','테스터9','q1w2e3r4',10);

insert into Member(id,name,password,user_mode)
values ('testuser0','테스터0','q1w2e3r4',10);


-- 작성글
insert into Post(publisher_no,title,text)
values (1,'너굴맨','사진은 이 너굴맨이 처리했으니 안심하라고!');

insert into Post(publisher_no,title,text)
values (1,'냥캣','사진은 이 냥캣이 처리했으니 안심하라고!');

insert into Post(publisher_no,title,text)
values (1,'도지','사진은 이 도지가 처리했으니 안심하라고!');

insert into Post(publisher_no,title,text)
values (1,'곰','사진은 이 곰이 처리했으니 안심하라고!');

insert into Post(publisher_no,title,text)
values (1,'일런마스크','사진은 이 테슬라가 처리했으니 안심하라고!');

insert into Post(publisher_no,title,text)
values (1,'일런마스크','사진은 이 테슬라가 처리했으니 안심하라고!');

insert into Post(publisher_no,title)
values (3,'테스트7');

insert into Post(publisher_no,title)
values (3,'테스트8');

insert into Post(publisher_no,title)
values (3,'테스트9');

--작성글 관련 사진
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(1,'raccoon_1.jpg','raccoon_1.jpg',true);
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(2,'cat_1.jpg','cat_1.jpg',true);
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(3,'dog_1.jpg','dog_1.jpg',true);
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(4,'bear_1.jpg','bear_1.jpg',true);
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(5,'musk_1.jpg','musk_1.jpg',true);
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(6,'musk_2.jpg','musk_2.jpg',true);

--댓글
insert into Comments(post_no,content)
values(1,'다시 가고 싶은 나라 1위!!');

