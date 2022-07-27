package com.proj.team.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.team.board.dao.BoardDAO;
import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	
	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}
	
	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}
	
	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}
	
	@Override
	public void update(BoardVO boardVO) throws Exception {
		dao.update(boardVO);
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}
}
