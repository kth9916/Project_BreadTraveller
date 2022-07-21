package com.proj.team.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.board.domain.FreeBoardVO;
import com.proj.team.board.domain.Pagination;

@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO {

	@Autowired
	SqlSession session;

	private static String NAMESPACE = "com.proj.team.board.dao.FreeBoardMapper.";

	@Override
	public List<FreeBoardVO> selectList(Pagination pagination) throws Exception{
		return session.selectList(NAMESPACE+"selectList",pagination);
	}

	@Override
	public FreeBoardVO read(int f_no) throws Exception {
		return session.selectOne(NAMESPACE+"selectOne",f_no);
	}
	
	@Override
	public void insert(FreeBoardVO vo) throws Exception{
		session.insert(NAMESPACE+"insert",vo);
	}

	@Override
	public void update(FreeBoardVO vo) throws Exception{
		session.update(NAMESPACE+"modify",vo);
	}

	@Override
	public void delete(int f_no) throws Exception{
		session.delete(NAMESPACE+"remove", f_no	);
	}
	
	@Override
	public void hitUpdate(int f_no) throws Exception {
		session.update(NAMESPACE+"hitUpdate",f_no);
	}

	@Override
	public int getBoardListCnt() throws Exception {
		return session.selectOne(NAMESPACE+"getBoardListCnt");
	}
		

}
