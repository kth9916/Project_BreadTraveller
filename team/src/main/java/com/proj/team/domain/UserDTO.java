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
	public String u_id      ;          //�������̵� ����ũŰ?
	public String u_pass    ;          //��й�ȣ
	public String u_email   ;          //�̸���
	public String u_grade   ;       	//���
	public String u_phone   ;          //�ڵ���
	public String u_birth   ;          //����
	public String u_nick    ;         	//�г���
	public String u_gender  ;       	//����
	public String u_address ;          //�ּ�
	public String u_post    ;          //�����ȣ
	public String u_name    ;          //�̸�
	public String u_profile ;   		//������ ����
	public int point     ;          //����Ʈ
	public int apoint    ;          //���� ����Ʈ
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date u_date    ;       	//������
	public String likesStore     ;          //���ƿ� ����
	public String likesBoard     ;          //���ƿ� �Խñ�
	public String question  ;          //���̵� ã��� ����
	public String answer    ;          //�亯
=======
	private int u_num		;		//primary key
	private String u_id      ;          //유저아이디 유니크키?
	private String u_pass    ;          //비밀번호
	private String u_email   ;          //이메일
	private String u_grade   ;       	//등급
	private String u_phone   ;          //핸드폰
	private String u_birth   ;          //생일
	private String u_nick    ;         	//닉네임
	private String u_gender  ;       	//성별
	private String u_address ;          //주소
	private String u_post    ;          //우편번호
	private String u_name    ;          //이름
	private String u_profile ;   		//프로필 사진
	private int point     ;          //포인트
	private int apoint    ;          //누적 포인트
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date u_date    ;       	//가입일
	private String likesStore     ;          //좋아요 상점
	private String likesBoard     ;          //좋아요 게시글
	private String question  ;          //아이디 찾기용 질문
	private String answer    ;          //답변

	
>>>>>>> gyh
}

