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
	public String u_id      ;          //유저아이디 유니크키?
	public String u_pass    ;          //비밀번호
	public String u_email   ;          //이메일
	public String u_grade   ;       	//등급
	public String u_phone   ;          //핸드폰
	public String u_birth   ;          //생일
	public String u_nick    ;         	//닉네임
	public String u_gender  ;       	//성별
	public String u_address ;          //주소
	public String u_post    ;          //우편번호
	public String u_name    ;          //이름
	public String u_profile ;   		//프로필 사진
	public int point     ;          //포인트
	public int apoint    ;          //누적 포인트
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date u_date    ;       	//가입일
	public String likesStore     ;          //좋아요 상점
	public String likesBoard     ;          //좋아요 게시글
	public String question  ;          //아이디 찾기용 질문
	public String answer    ;          //답변
=======
	private int u_num		;		//primary key
	private String u_id      ;          //�쑀����븘�씠�뵒 �쑀�땲�겕�궎?
	private String u_pass    ;          //鍮꾨��踰덊샇
	private String u_email   ;          //�씠硫붿씪
	private String u_grade   ;       	//�벑湲�
	private String u_phone   ;          //�빖�뱶�룿
	private String u_birth   ;          //�깮�씪
	private String u_nick    ;         	//�땳�꽕�엫
	private String u_gender  ;       	//�꽦蹂�
	private String u_address ;          //二쇱냼
	private String u_post    ;          //�슦�렪踰덊샇
	private String u_name    ;          //�씠由�
	private String u_profile ;   		//�봽濡쒗븘 �궗吏�
	private int point     ;          //�룷�씤�듃
	private int apoint    ;          //�늻�쟻 �룷�씤�듃
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date u_date    ;       	//媛��엯�씪
	private String likesStore     ;          //醫뗭븘�슂 �긽�젏
	private String likesBoard     ;          //醫뗭븘�슂 寃뚯떆湲�
	private String question  ;          //�븘�씠�뵒 李얘린�슜 吏덈Ц
	private String answer    ;          //�떟蹂�

	
>>>>>>> gyh
}

