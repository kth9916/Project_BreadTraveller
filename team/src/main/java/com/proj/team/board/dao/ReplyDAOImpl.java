package com.proj.team.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.board.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Autowired
	SqlSession session;
	
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return session.selectList("replyMapper.readReply",bno);
	}
	
	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		session.insert("replyMapper.writeReply",vo);
	}

	@Override
	public void updateReply(ReplyVO vo) throws Exception {
		session.update("replyMapper.updateReply",vo);
	}

	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		session.delete("replyMapper.deleteReply",vo);
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {
		return session.selectOne("replyMapper.selectReply",rno);
	}
	
	
}
