create table b_user(
u_num number not null primary key,                  -- primary key
u_id varchar2 (30) not null UNIQUE,                 -- �������̵� ����ũŰ?
u_pass varchar2 (30) not null,                      -- ��й�ȣ
u_email varchar2 (40) not null,                       -- �̸���
u_grade varchar2 (20) default '1' not null,           -- ���
u_phone varchar2 (20) not null,                       -- �ڵ���
u_birth varchar2(200) not null,                         -- ����
u_nick varchar2 (20) not null,                        -- �г���
u_gender varchar2 (20) null,                      -- ����
u_address varchar2(4000) null,                    -- �ּ�
u_post varchar2 (400) null,                       -- �����ȣ
u_name varchar2 (20) not null,                      -- �̸�
u_profile varchar2 (40) default 'sample.jpg' not null,    -- ������ ����
point number default 0 not null,                    -- ����Ʈ
apoint number default 0 not null,                   -- ���� ����Ʈ
u_date date default sysdate not null,               -- ������
likesStore varchar2 (2000) null,                         -- ���ƿ� ����
likesBoard varchar2 (2000) null,                         -- ���ƿ� �Խù�
question varchar2(4000) not null,                   -- ���̵� ã��� ����
answer varchar2 (4000) not null                     -- �亯
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