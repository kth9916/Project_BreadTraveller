create table b_user(
u_num number not null primary key,                  -- primary key
u_id varchar2 (30) not null UNIQUE,                 -- �������̵� ����ũŰ?
u_pass varchar2 (30) not null,                      -- ��й�ȣ
email varchar2 (40) not null,                       -- �̸���
grade varchar2 (20) default '1' not null,           -- ���
phone varchar2 (20) not null,                       -- �ڵ���
nick varchar2 (20) not null,                        -- �г���
address varchar2(4000) not null,                    -- �ּ�
post varchar2 (400) not null,                       -- �����ȣ
u_name varchar2 (20) not null,                      -- �̸�
u_profile varchar2 (40) default 'sample.jpg' not null,    -- ������ ����
point number default 0 not null,                    -- ����Ʈ
apoint number default 0 not null,                   -- ���� ����Ʈ
u_date date default sysdate not null,               -- ������
likes varchar2 (2000) null,                         -- ���ƿ� �Խù�?
question varchar2(4000) not null,                   -- ���̵� ã��� ����
answer varchar2 (4000) not null                     -- �亯
);

drop table b_user;


INSERT INTO b_user(U_NUM,U_ID,U_PASS,EMAIL,PHONE,NICK,ADDRESS,POST,U_NAME,QUESTION,ANSWER)
VALUES (1,'a','a','a','a','a','a','a','a','a','a');

commit;


create sequence u_num
    increment by 1
    start with 1
    nocache;

    	SELECT count(*)
 	FROM B_USER
 	WHERE U_ID='b' 
 	AND U_PASS='n';