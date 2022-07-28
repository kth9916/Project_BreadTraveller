package com.proj.team.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession session;

	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		session.insert("boardMapper.insert",boardVO);
	}
	
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return session.selectList("boardMapper.listPage",scri);
	}
	
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return session.selectOne("boardMapper.listCount",scri);
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
	
	
	
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		session.insert("boardMapper.insertFile", map);
	}
	
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return session.selectList("boardMapper.selectFileList", bno);
	}
	
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return session.selectOne("boardMapper.selectFileInfo", map);
	}
	
	@Override
	public void updateFile(Map<String, Object> map) throws Exception {
		session.update("boardMapper.updateFile", map);
	}
	
	@Override
	public void boardHit(int bno) throws Exception {
		session.update("boardMapper.boardHit", bno);
	}
}
