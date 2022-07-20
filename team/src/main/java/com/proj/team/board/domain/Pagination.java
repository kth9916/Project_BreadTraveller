package com.proj.team.board.domain;

import lombok.Data;

@Data
public class Pagination {
	
	private int listSize = 10;	//목록 개수
	private int rangeSize = 10;	//페이지 범위
	private int page;			//현재 페이지 
	private int range;			//현재 페이지 범위
	private int listCnt;		//게시물 총 개수
	private int pageCnt;		//전체 페이지 개수
	private int startPage;
	private int startList;		//게시판 시작 번호
	private int endPage;
	
	private boolean prev;
	private boolean next;
	
	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		
		//전체 페이지 수 
		this.pageCnt = (int)Math.ceil(listCnt/listSize);
		
		//시작 페이지
		this.startPage = (range-1)*rangeSize + 1;
		
		//끝 페이지
		this.endPage = range * rangeSize;
		
		//게시판 시작번호
		this.startList = (page - 1) * listSize;
		
		//이전 버튼 상태
		this.prev = range == 1 ? false : true;
		
		//다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;
		
		if(this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
}
