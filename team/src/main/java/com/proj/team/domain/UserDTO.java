package com.proj.team.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString	
public class UserDTO {
	
<<<<<<< HEAD
	public int u_num		;		//primary key
	public String u_id      ;          //À¯Àú¾ÆÀÌµð À¯´ÏÅ©Å°?
	public String u_pass    ;          //ºñ¹Ð¹øÈ£
	public String u_email   ;          //ÀÌ¸ÞÀÏ
	public String u_grade   ;       	//µî±Þ
	public String u_phone   ;          //ÇÚµåÆù
	public String u_birth   ;          //»ýÀÏ
	public String u_nick    ;         	//´Ð³×ÀÓ
	public String u_gender  ;       	//¼ºº°
	public String u_address ;          //ÁÖ¼Ò
	public String u_post    ;          //¿ìÆí¹øÈ£
	public String u_name    ;          //ÀÌ¸§
	public String u_profile ;   		//ÇÁ·ÎÇÊ »çÁø
	public int point     ;          //Æ÷ÀÎÆ®
	public int apoint    ;          //´©Àû Æ÷ÀÎÆ®
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date u_date    ;       	//°¡ÀÔÀÏ
	public String likesStore     ;          //ÁÁ¾Æ¿ä »óÁ¡
	public String likesBoard     ;          //ÁÁ¾Æ¿ä °Ô½Ã±Û
	public String question  ;          //¾ÆÀÌµð Ã£±â¿ë Áú¹®
	public String answer    ;          //´äº¯
=======
	private int u_num		;		//primary key
	private String u_id      ;          //ìœ ì €ì•„ì´ë”” ìœ ë‹ˆí¬í‚¤?
	private String u_pass    ;          //ë¹„ë°€ë²ˆí˜¸
	private String u_email   ;          //ì´ë©”ì¼
	private String u_grade   ;       	//ë“±ê¸‰
	private String u_phone   ;          //í•¸ë“œí°
	private String u_birth   ;          //ìƒì¼
	private String u_nick    ;         	//ë‹‰ë„¤ìž„
	private String u_gender  ;       	//ì„±ë³„
	private String u_address ;          //ì£¼ì†Œ
	private String u_post    ;          //ìš°íŽ¸ë²ˆí˜¸
	private String u_name    ;          //ì´ë¦„
	private String u_profile ;   		//í”„ë¡œí•„ ì‚¬ì§„
	private int point     ;          //í¬ì¸íŠ¸
	private int apoint    ;          //ëˆ„ì  í¬ì¸íŠ¸
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date u_date    ;       	//ê°€ìž…ì¼
	private String likesStore     ;          //ì¢‹ì•„ìš” ìƒì 
	private String likesBoard     ;          //ì¢‹ì•„ìš” ê²Œì‹œê¸€
	private String question  ;          //ì•„ì´ë”” ì°¾ê¸°ìš© ì§ˆë¬¸
	private String answer    ;          //ë‹µë³€

	
>>>>>>> gyh
}

