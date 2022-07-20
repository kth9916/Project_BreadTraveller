package com.proj.team.board.dao;

import java.util.List;

import com.proj.team.board.domain.FreeBoardVO;
import com.proj.team.board.domain.Pagination;

public interface FreeBoardDAO {
	
	public List<FreeBoardVO> selectList(Pagination pagination) throws Exception;
	public FreeBoardVO read(int f_no) throws Exception; 
	public void insert(FreeBoardVO vo) throws Exception;
	public void update(FreeBoardVO vo) throws Exception;
	public void delete(int f_no) throws Exception;
	public void hitUpdate(int f_no) throws Exception;
	
	public int getBoardListCnt() throws Exception;
	
}
