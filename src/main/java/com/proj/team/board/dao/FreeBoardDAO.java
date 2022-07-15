package com.proj.team.board.dao;

import java.util.HashMap;
import java.util.List;

import com.proj.team.board.domain.FreeBoardVO;

public interface FreeBoardDAO {
	
	void insertBoard(FreeBoardVO vo) throws Exception;
	void updateBoard(FreeBoardVO vo) throws Exception;
	void deleteBoard(FreeBoardVO vo) throws Exception;
	FreeBoardVO getBoard(int f_no) throws Exception;
	List<FreeBoardVO> getBoardList(HashMap<String,Object> paramMap) throws Exception;
	int upHit(int f_no) throws Exception; 
	String loginCheck(String u_id) throws Exception;
	int replyBoard(FreeBoardVO vo) throws Exception;
	
}
