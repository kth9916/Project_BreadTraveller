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
}

