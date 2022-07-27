package com.proj.team.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession session;

	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		session.insert("boardMapper.insert",boardVO);
	}
	
	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		return session.selectList("boardMapper.listPage",cri);
	}
	
	@Override
	public int listCount() throws Exception {
		return session.selectOne("boardMapper.listCount");
	}
	
	@Override
	public BoardVO read(int bno) throws Exception {
		return session.selectOne("boardMapper.read", bno);
	}
	
	@Override
	public void update(BoardVO boardVO) throws Exception {
		session.update("boardMapper.update", boardVO);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		session.delete("boardMapper.delete", bno);
	}
}
