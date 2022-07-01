create table b_user(
u_num number not null primary key,                  -- primary key
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
likes varchar2 (2000) null,                         -- 좋아요 게시물?
question varchar2(4000) not null,                   -- 아이디 찾기용 질문
answer varchar2 (4000) not null                     -- 답변
);

drop table b_user;

create sequence u_num
    increment by 1
    start with 1
    nocache;