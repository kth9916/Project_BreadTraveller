package com.proj.team.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.board.domain.FreeBoardVO;

@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO {

	@Autowired
	SqlSession session;

	private static String NAMESPACE = "com.proj.team.board.dao.FreeBoardMapper.";

	@Override
	public List<FreeBoardVO> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FreeBoardVO selectOne(int f_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int f_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
