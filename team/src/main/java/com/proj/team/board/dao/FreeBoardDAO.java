package com.proj.team.board.dao;

import java.util.HashMap;
import java.util.List;

import com.proj.team.board.domain.FreeBoardVO;

public interface FreeBoardDAO {
	
	public List<FreeBoardVO> selectList();
	public FreeBoardVO selectOne(int f_no);
	public int insert(FreeBoardVO vo);
	public int update(FreeBoardVO vo);
	public int delete(int f_no);
}
