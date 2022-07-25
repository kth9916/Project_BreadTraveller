package com.proj.team.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.team.board.dao.FreeBoardDAO;
import com.proj.team.board.domain.BoardReplyVO;
import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.FileVO;
import com.proj.team.board.domain.SearchVO;

@Service
@Transactional(readOnly = true)
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDAO dao;

	@Override
	public Integer selectBoardCount(SearchVO vo) throws Exception {
		return dao.selectBoardCount(vo);
	}

	@Override
	public List<?> selectBoardList(SearchVO vo) throws Exception {
		return dao.selectBoardList(vo);
	}

	@Override
	public void insertBoard(BoardVO vo, List<FileVO> filelist, String[] fileno) throws Exception {
		dao.insertBoard(vo, filelist, fileno);
	}

	@Override
	public BoardVO selectBoardOne(String param) throws Exception {
		return dao.selectBoardOne(param);
	}

	@Override
	public void updateBoardRead(String param) throws Exception {
		dao.updateBoardRead(param);
		
	}

	@Override
	public void deleteBoardOne(String param) throws Exception {
		dao.deleteBoardOne(param);
	}

	@Override
	public List<?> selectBoardFileList(String param) throws Exception {
		return dao.selectBoardFileList(param);
	}

	@Override
	public List<?> selectBoardReplyList(String param) throws Exception {
		return dao.selectBoardReplyList(param);
	}

	@Override
	public void insertBoardReply(BoardReplyVO vo) throws Exception {
		dao.insertBoardReply(vo);
	}

	@Override
	public boolean deleteBoardReply(String param) throws Exception {
		return dao.deleteBoardReply(param);
	}

	
}
