create table b_user(
u_num number not null primary key,                  -- primary key
<<<<<<< HEAD
u_id varchar2 (30) not null UNIQUE,                 -- À¯Àú¾ÆÀÌµð À¯´ÏÅ©Å°?
u_pass varchar2 (30) not null,                      -- ºñ¹Ð¹øÈ£
u_email varchar2 (40) not null,                       -- ÀÌ¸ÞÀÏ
u_grade varchar2 (20) default '1' not null,           -- µî±Þ
u_phone varchar2 (20) not null,                       -- ÇÚµåÆù
u_birth varchar2(200) not null,                         -- »ýÀÏ
u_nick varchar2 (20) not null,                        -- ´Ð³×ÀÓ
u_gender varchar2 (20) null,                      -- ¼ºº°
u_address varchar2(4000) null,                    -- ÁÖ¼Ò
u_post varchar2 (400) null,                       -- ¿ìÆí¹øÈ£
u_name varchar2 (20) not null,                      -- ÀÌ¸§
u_profile varchar2 (40) default 'sample.jpg' not null,    -- ÇÁ·ÎÇÊ »çÁø
point number default 0 not null,                    -- Æ÷ÀÎÆ®
apoint number default 0 not null,                   -- ´©Àû Æ÷ÀÎÆ®
u_date date default sysdate not null,               -- °¡ÀÔÀÏ
likesStore varchar2 (2000) null,                         -- ÁÁ¾Æ¿ä »óÁ¡
likesBoard varchar2 (2000) null,                         -- ÁÁ¾Æ¿ä °Ô½Ã¹°
question varchar2(4000) not null,                   -- ¾ÆÀÌµð Ã£±â¿ë Áú¹®
answer varchar2 (4000) not null                     -- ´äº¯
=======
u_id varchar2 (30) not null UNIQUE,                 -- ìœ ì €ì•„ì´ë”” ìœ ë‹ˆí¬í‚¤?
u_pass varchar2 (30) not null,                      -- ë¹„ë°€ë²ˆí˜¸
u_email varchar2 (40) not null,                       -- ì´ë©”ì¼
u_grade varchar2 (20) default '1' not null,           -- ë“±ê¸‰
u_phone varchar2 (20) not null,                       -- í•¸ë“œí°
u_birth varchar2(200) not null,                         -- ìƒì¼
u_nick varchar2 (20) not null,                        -- ë‹‰ë„¤ìž„
u_gender varchar2 (20) null,                      -- ì„±ë³„
u_address varchar2(4000) null,                    -- ì£¼ì†Œ
u_post varchar2 (400) null,                       -- ìš°íŽ¸ë²ˆí˜¸
u_name varchar2 (20) not null,                      -- ì´ë¦„
u_profile varchar2 (40) default 'sample.jpg' not null,    -- í”„ë¡œí•„ ì‚¬ì§„
point number default 0 not null,                    -- í¬ì¸íŠ¸
apoint number default 0 not null,                   -- ëˆ„ì  í¬ì¸íŠ¸
u_date date default sysdate not null,               -- ê°€ìž…ì¼
likesStore varchar2 (2000) null,                         -- ì¢‹ì•„ìš” ìƒì 
likesBoard varchar2 (2000) null,                         -- ì¢‹ì•„ìš” ê²Œì‹œë¬¼
question varchar2(4000) not null,                   -- ì•„ì´ë”” ì°¾ê¸°ìš© ì§ˆë¬¸
answer varchar2 (4000) not null                     -- ë‹µë³€
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