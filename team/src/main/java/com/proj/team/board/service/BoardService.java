package com.proj.team.board.service;

import java.util.List;

import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.Criteria;

public interface BoardService {
	
	public void write(BoardVO boardVO) throws Exception;
	public List<BoardVO> list(Criteria cri) throws Exception;
	public int listCount() throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void update(BoardVO boardVO) throws Exception;
	public void delete(int bno) throws Exception;
	
}
