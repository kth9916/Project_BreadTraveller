CREATE TABLE F_BOARD(
    BNO NUMBER NOT NULL,
    TITLE VARCHAR2(100)     NOT NULL,
    CONTENT VARCHAR2(2000)  NOT NULL,
    WRITER VARCHAR2(100)    NOT NULL,
    REGDATE DATE            DEFAULT SYSDATE,
    HIT NUMBER              DEFAULT 0,
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


create table F_reply (
    bno number not null,
    rno number not null,
    content varchar2(1000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    primary key(bno, rno)
);

alter table F_reply add constraint F_reply_bno foreign key(bno)
references F_board(bno);

create sequence F_reply_seq START WITH 1 MINVALUE 0;

commit;


CREATE TABLE F_FILE
(
    FILE_NO NUMBER,                         --파일 번호
    BNO NUMBER NOT NULL,                    --게시판 번호
    ORG_FILE_NAME VARCHAR2(260) NOT NULL,   --원본 파일 이름
    STORED_FILE_NAME VARCHAR2(36) NOT NULL, --변경된 파일 이름
    FILE_SIZE NUMBER,                       --파일 크기
    REGDATE DATE DEFAULT SYSDATE NOT NULL,  --파일등록일
    DEL_GB VARCHAR2(1) DEFAULT 'N' NOT NULL,--삭제구분
    PRIMARY KEY(FILE_NO)                    --기본키 FILE_NO
);

CREATE SEQUENCE SEQ_F_FILE_NO
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE NOCACHE;

COMMIT;
