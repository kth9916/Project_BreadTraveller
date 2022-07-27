create table TBL_BOARD(
    bgno varchar2(100),
    brdno varchar2(20) primary key,       --게시물 번호
    brdtitle varchar2(100) not null,         --제목
    brdmemo varchar2(4000) not null,      --게시물 내용
    brdwriter varchar2(30) not null,         --글쓴이
    brddate timestamp  default sysdate not null, --글 쓴 날짜    
    brdhit number  ,                  --조회수
    replycnt varchar2(500),                   --댓글
    brddeleteflag varchar(10) default 'N',
    filecnt varchar(100),
    likecnt varchar(100)
);


create sequence BRDNO_SEQ
increment by 1
start with 1
nocache;



create table TBL_BOARDREPLY(
    reno varchar2(20) primary key,
    brdno varchar2(20) ,
    rememo varchar2(2000),
    rewriter varchar2(30),
    redate timestamp not null,
    redeleteflag varchar2(10),
    reparent varchar2(20),
    redepth varchar2(20),
    reorder number
);

create table TBL_BOARDFILE(
    brdno varchar2(20),
    fileno number,
    filename varchar2(100),
    realname varchar2(200),
    filesize number
    
);

create sequence FILENO_SEQ
increment by 1
start with 1
nocache;


create table liketo(
    likeno number(5) not null primary key,
    brdno varchar(20) not null,
    u_num number,
    heart number(5) default 0 null,
    foreign key(u_num) references b_user(u_num),
    foreign key(brdno) references tbl_board(brdno)
);


drop table tbl_board;
drop table liketo;
drop table tbl_board;
drop table TBL_BOARDFILE;
drop table TBL_BOARDREPLY;



----=-------------------------------------------------------------------

CREATE TABLE F_BOARD(
    BNO NUMBER NOT NULL,
    TITLE VARCHAR2(100)     NOT NULL,
    CONTENT VARCHAR2(2000)  NOT NULL,
    WRITER VARCHAR2(100)    NOT NULL,
    REGDATE DATE            DEFAULT SYSDATE,
    PRIMARY KEY(BNO)
);

CREATE SEQUENCE F_BOARD_SEQ
START WITH 1
INCREMENT BY 1;

INSERT INTO F_BOARD(BNO, TITLE, CONTENT, WRITER)
     VALUES (F_BOARD_SEQ.NEXTVAL, '제목입니다', '내용입니다', 'MELONPEACH');

SELECT * FROM F_BOARD;
COMMIT;


--더미데이터 두 배 증가 쿼리
insert into f_board(bno, title, content, writer)
select f_board_seq.nextval, title, content, writer from f_board;
commit;

