package com.proj.team.board.domain;

import lombok.Data;

@Data
public class FreeBoardVO {
	private int f_no;			//게시물 번호
	private String f_title;		//제목
	private String f_content;	//게시물 내용
	private String f_writer;	//글쓴이
	private String f_wdate;		//글 쓴 날짜
	private int f_hit;			//조회수
	private String f_reply;		//댓글
}
