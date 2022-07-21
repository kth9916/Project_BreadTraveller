package com.proj.team.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.team.board.dao.FreeBoardDAO;
import com.proj.team.board.domain.FreeBoardVO;
import com.proj.team.board.domain.Pagination;

@Service
@Transactional(readOnly = true)
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDAO dao;

	@Override
	public List<FreeBoardVO> selectList(Pagination pagination) throws Exception {
		return dao.selectList(pagination);
	}

	
	@Override
	public FreeBoardVO read(int f_no) throws Exception {
		dao.hitUpdate(f_no);
		return dao.read(f_no);
	}

	@Transactional
	@Override
	public void insert(FreeBoardVO vo) throws Exception {
		dao.insert(vo);
	}

	@Transactional
	@Override
	public void update(FreeBoardVO vo) throws Exception {
		dao.update(vo);
	}

	@Transactional
	@Override
	public void delete(int f_no) throws Exception {
		dao.delete(f_no);
	}

	@Override
	public int getBoardListCnt() throws Exception {
		return dao.getBoardListCnt();
	}
	
}
