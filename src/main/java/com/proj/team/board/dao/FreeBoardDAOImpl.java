package com.proj.team.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.board.domain.FreeBoardVO;

@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO{

	@Autowired
	SqlSession session;
	
    private static String namespace = "com.proj.team.board.dao.FreeBoardMapper.";
    
    /**
     * 게시물 등록
     */
	@Override
	public void insertBoard(FreeBoardVO vo) throws Exception {
		session.insert(namespace + "insertBoard",vo);
	}

	/**
	 * 게시물 수정
	 */
	@Override
	public void updateBoard(FreeBoardVO vo) throws Exception {
		session.update(namespace +"updateBoard",vo);
	}

	/**
	 * 게시물 삭제
	 */
	@Override
	public void deleteBoard(FreeBoardVO vo) throws Exception {
		session.delete(namespace+"deleteBoard",vo);
	}

	/**
	 * 번호에 맞는 게시물 하나 가져오기
	 */
	@Override
	public FreeBoardVO getBoard(int f_no) throws Exception {	//read
		return session.selectOne(namespace+"getBoard",f_no);
	}

	/**
	 * 게시물 전부 갖고오기
	 */
	@Override
	public List<FreeBoardVO> getBoardList(HashMap<String,Object> paramMap) throws Exception {
		return session.selectList(namespace+"getBoardList",paramMap);
	}

	/**
	 * 조회수 증가
	 */
	@Override
	public int upHit(int f_no) throws Exception {
		return session.update(namespace+"upHit",f_no);
	}
	
	/**
	 * 로그인 체크 
	 */
	@Override
	public String loginCheck(String u_id) throws Exception {
		return session.selectOne(namespace+"loginCheck",u_id);
	}
	
	/**
	 * 답글
	 */
	@Override
	public int replyBoard(FreeBoardVO vo) throws Exception {
		return session.insert(namespace+"replyBoard",vo);
	}
	
	
}
