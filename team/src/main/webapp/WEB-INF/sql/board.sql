create table TBL_BOARD(
    bgno varchar2(100),
    brdno varchar2(20) primary key,       --게시물 번호
    brdtitle varchar2(100) not null,         --제목
    brdmemo varchar2(4000) not null,      --게시물 내용
    brdwriter varchar2(30) not null,         --글쓴이
    brddate timestamp  default sysdate not null, --글 쓴 날짜    
    brdhit number not null,                  --조회수
    replycnt varchar2(500),                   --댓글
    brddeleteflag varchar(10) default 'N',
    filecnt varchar(100)
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
    fileno number primary key,
    parentPK varchar2(20),
    filename varchar2(100),
    realname varchar2(200),
    filesize number
    
);

create sequence FILENO_SEQ
increment by 1
start with 1
nocache;

