
create table b_user(
id varchar2 (100) not null primary key,            -- primary key
u_id varchar2 (30) not null,                        -- �������̵� ����ũŰ?
u_pass varchar2 (30) not null,                      -- ��й�ȣ
email varchar2 (40) not null,                       -- �̸���
grade varchar2 (20) default '1' not null,           -- ���
phone varchar2 (20) not null,                       -- �ڵ���
nick varchar2 (20) not null,                        -- �г���
u_name varchar2 (20) not null,                      -- �̸�
u_profile varchar2 (40) default 'none' not null,    -- ������ ����
point number default 0 not null,                    -- ����Ʈ
apoint number default 0 not null,                   -- ���� ����Ʈ
u_date date default sysdate not null,                -- ������
likes varchar2(2000) null,                                   -- ���ƿ� �Խù�?
question varchar2(1000) not null,                    -- ���̵� ã��� ����
answer varchar2 (1000) not null                        -- �亯
);
insert into b_user (u_num, u_id,u_pass,email,phone,nick,address,post,u_name,likes,question,answer)
values(2,'a','a','a','a','a','a','a','a','a','a','a');
select * from b_user;
commit;