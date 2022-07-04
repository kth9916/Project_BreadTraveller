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
}

