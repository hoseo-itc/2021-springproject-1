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
-- 1)
insert into Post(publisher_no,title,text)
values (4,'옥돌 해수욕장','[푸르른 바다 앞에서 즐기는 해물라면 먹방이라니...♥]풍경 한 입 해물라면 한 입♡\n올 여름 피서는 여기 각 아닙니까...?\n\n군산 옥돌슈퍼\n전라북도 군산시 옥도면 선유남3길 10');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(1,'KakaoTalk_20210626_213458026.png','KakaoTalk_20210626_213458026.png',true);
--insert into Comments(post_no,content) values();

-- 2)
insert into Post(publisher_no,title,text)
values (5,'강아지와의 동반여행','여행에 미치다.\n애견동반여행\n댕댕이\n\n삼척 장호항');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(2,'KakaoTalk_20210626_213458026_01.png','KakaoTalk_20210626_213458026_01.png',true);

-- 3)
insert into Post(publisher_no,title,text)
values (6,'댕댕이와 물놀이 해보셨나요?','강원도 강릉 경포해변');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(3,'KakaoTalk_20210626_213458026_02.png','KakaoTalk_20210626_213458026_02.png',true);

-- 4)
insert into Post(publisher_no,title,text)
values (7,'놀이동산에서','충청남도 당신 삽호 놀이공원!');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(4,'KakaoTalk_20210626_213458026_03.png','KakaoTalk_20210626_213458026_03.png',true);

-- 5)
insert into Post(publisher_no,title,text)
values (8,'다시는 볼수없을 홍콩','홍콩 워홀떄 자주 사먹은 로컬 마라면, 휴무때마다 여행하던 곳 식당에서 마신 해피아워 생맥주,로컬민들만 아는 허름한 노포음식...\n\n아... 또 가고 싶다...');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(5,'KakaoTalk_20210626_213458026_04.png','KakaoTalk_20210626_213458026_04.png',true);

-- 6)
insert into Post(publisher_no,title,text)
values (4,'청포리가 드넓게 펼쳐지는 당진의 카페','야외 테이블 앞에 푸르른 청보리 밭이 펄쳐져있어\n앉아있으면 바람에 흔들리는 청보리 소리가 기분 좋아져요 :)\n피어라 에이드와 할머니 당근케이크가 대표메뉴!\n\n카페티어라\n충남 당진시 합덕읍 합덕대덕로 502-24\n영업시간-매일 10:30-20:00');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(6,'KakaoTalk_20210626_213458026_05.png','KakaoTalk_20210626_213458026_05.png',true);

-- 7)
insert into Post(publisher_no,title,text)
values (5,'옥돌 해수욕장','[푸르른 바다 앞에서 즐기는 해물라면 먹방이라니...♥]풍경 한 입 해물라면 한 입♡\n올 여름 피서는 여기 각 아닙니까...?\n\n군산 옥돌슈퍼\n전라북도 군산시 옥도면 선유남3길 10');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(7,'KakaoTalk_20210626_213458026_06.png','KakaoTalk_20210626_213458026_06.png',true);

-- 8)
insert into Post(publisher_no,title,text)
values (6,'청산도에 쉬어리랏다','어제 방송된 만남의 광장에서 완도 특산물 전복이 소개되었더라구요:)\n여미도 얼마 전 완도를 다녀왔는데, 정말 살면서 먹은 전복 개수보다 2박,3일간 완도에서 먹은 전복이 더 많을 정도였어요.\n\n전복말고도 사실 풍경이 너무 아름다운 곳이였어요!\n모두 한번씩 가보셨으면 좋겠네요^^');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(8,'KakaoTalk_20210626_213458026_07.png','KakaoTalk_20210626_213458026_07.png',true);

-- 9)
insert into Post(publisher_no,title,text)
values (8,'봄꽃같은나','? 나 찍었는데 왜 꽃밖에 안보이지?\n심령사진인가?\n');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(9,'KakaoTalk_20210626_213458026_08.png','KakaoTalk_20210626_213458026_08.png',true);

-- 10)
insert into Post(publisher_no,title,text)
values (4,'향기롭고 감각적인 제주도 카페','내부로 들어가는 순간 느껴지는 그윽한 차의 향기에\n마음이 차분해 졌던 공간.\n\n이 곳만의 시그니쳐는 도라에몽 어디로든 문이 떠오르는\n포토스팟과 독특한 디자인의 영롱한 찾잔인 것 같아요.\n');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(10,'KakaoTalk_20210626_213458026_09.png','KakaoTalk_20210626_213458026_09.png',true);

-- 11)
insert into Post(publisher_no,title,text)
values (5,'코인의 시대, 코인의 원조였던 튤립으로 마음정화','이번주부터 다음주까지 튤립이 활작판다고 하네요. 다들 튤립보고 떡상하십쇼!');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(11,'KakaoTalk_20210626_213458026_10.png','KakaoTalk_20210626_213458026_10.png',true);

-- 12)
insert into Post(publisher_no,title,text)
values (6,'지혜와 함께','날씨 미쳣다...\n\nX 포샵\n');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(12,'KakaoTalk_20210626_213458026_11.png','KakaoTalk_20210626_213458026_11.png',true);

-- 13)
insert into Post(publisher_no,title,text)
values (6,'드론 값 뽑은것같다','이맛에 드론 띄우지\n\n벚꽃 만개한 석촌호수');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(13,'KakaoTalk_20210626_213458026_12.png','KakaoTalk_20210626_213458026_12.png',true);

-- 14)
insert into Post(publisher_no,title,text)
values (7,'코로나 전 찍었던 일본 여행 사진','코로나 끝나면 또 가야지');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(14,'KakaoTalk_20210626_213458026_13.png','KakaoTalk_20210626_213458026_13.png',true);

-- 15)
insert into Post(publisher_no,title,text)
values (8,'제주도','날씨 너무 맑다~!~!~!~!~!');
insert into UploadFile(post_no,origin_name,encode_name,visible)
values(15,'KakaoTalk_20210626_213458026_14.png','KakaoTalk_20210626_213458026_14.png',true);

--댓글
insert into Comments(post_no,content)
values(1,'다시 가고 싶은 나라 1위!!');

