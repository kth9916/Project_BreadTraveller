create table f_board(
    f_no number not null primary key,       --게시물 번호
    f_title varchar2(100) not null,         --제목
    f_content varchar2(4000) not null,      --게시물 내용
    f_writer varchar2(30) not null,         --글쓴이
    f_wdate timestamp  default sysdate not null, --글 쓴 날짜    
    f_hit number not null,                  --조회수
    f_reply varchar2(500)                   --댓글
);

insert into f_board(f_no, u_id, f_title,f_content,f_writer,f_wdate,f_hit,f_reply)
values(1,'a','a','a','a',sysdate,1,'a');

create sequence f_seq
increment by 1
start with 1
nocache;