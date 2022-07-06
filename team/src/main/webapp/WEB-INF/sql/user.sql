create table b_user(
u_num number not null primary key,                  -- primary key
<<<<<<< HEAD
u_id varchar2 (30) not null UNIQUE,                 -- 유저아이디 유니크키?
u_pass varchar2 (30) not null,                      -- 비밀번호
u_email varchar2 (40) not null,                       -- 이메일
u_grade varchar2 (20) default '1' not null,           -- 등급
u_phone varchar2 (20) not null,                       -- 핸드폰
u_birth varchar2(200) not null,                         -- 생일
u_nick varchar2 (20) not null,                        -- 닉네임
u_gender varchar2 (20) null,                      -- 성별
u_address varchar2(4000) null,                    -- 주소
u_post varchar2 (400) null,                       -- 우편번호
u_name varchar2 (20) not null,                      -- 이름
u_profile varchar2 (40) default 'sample.jpg' not null,    -- 프로필 사진
point number default 0 not null,                    -- 포인트
apoint number default 0 not null,                   -- 누적 포인트
u_date date default sysdate not null,               -- 가입일
likesStore varchar2 (2000) null,                         -- 좋아요 상점
likesBoard varchar2 (2000) null,                         -- 좋아요 게시물
question varchar2(4000) not null,                   -- 아이디 찾기용 질문
answer varchar2 (4000) not null                     -- 답변
=======
u_id varchar2 (30) not null UNIQUE,                 -- �쑀����븘�씠�뵒 �쑀�땲�겕�궎?
u_pass varchar2 (30) not null,                      -- 鍮꾨��踰덊샇
u_email varchar2 (40) not null,                       -- �씠硫붿씪
u_grade varchar2 (20) default '1' not null,           -- �벑湲�
u_phone varchar2 (20) not null,                       -- �빖�뱶�룿
u_birth varchar2(200) not null,                         -- �깮�씪
u_nick varchar2 (20) not null,                        -- �땳�꽕�엫
u_gender varchar2 (20) null,                      -- �꽦蹂�
u_address varchar2(4000) null,                    -- 二쇱냼
u_post varchar2 (400) null,                       -- �슦�렪踰덊샇
u_name varchar2 (20) not null,                      -- �씠由�
u_profile varchar2 (40) default 'sample.jpg' not null,    -- �봽濡쒗븘 �궗吏�
point number default 0 not null,                    -- �룷�씤�듃
apoint number default 0 not null,                   -- �늻�쟻 �룷�씤�듃
u_date date default sysdate not null,               -- 媛��엯�씪
likesStore varchar2 (2000) null,                         -- 醫뗭븘�슂 �긽�젏
likesBoard varchar2 (2000) null,                         -- 醫뗭븘�슂 寃뚯떆臾�
question varchar2(4000) not null,                   -- �븘�씠�뵒 李얘린�슜 吏덈Ц
answer varchar2 (4000) not null                     -- �떟蹂�
>>>>>>> gyh
);

INSERT INTO b_user(U_NUM,U_ID,U_PASS,u_EMAIL,u_PHONE,u_birth, u_NICK,u_gender, u_ADDRESS,u_POST,U_NAME,QUESTION,ANSWER)
VALUES (1,'a','a','a','a','a','a','a','a','a','a','a','a');


	SELECT COUNT(U_ID)
 	FROM b_user
 	WHERE U_ID=#{u_id} 
 	AND U_PASS=#{u_pass}

drop table b_user;

create sequence u_num
    increment by 1
    start with 1
    nocache;