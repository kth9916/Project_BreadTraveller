create table b_user(
u_num number not null primary key,                  -- primary key
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
);

