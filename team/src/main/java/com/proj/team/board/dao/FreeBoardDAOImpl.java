package com.proj.team.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.proj.team.board.domain.BoardReplyVO;
import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.FileVO;
import com.proj.team.board.domain.SearchVO;

@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO {

	@Autowired
	SqlSession session;
	
	@Autowired
	DataSourceTransactionManager txManager;

	private static String NAMESPACE = "com.proj.team.board.dao.FreeBoardMapper.";
	
	   
    public Integer selectBoardCount(SearchVO param) {
        return session.selectOne(NAMESPACE+"selectBoardCount", param);
    }
    
    public List<?> selectBoardList(SearchVO param) {
        return session.selectList(NAMESPACE+"selectBoardList", param);
    }
    
    /**
     * 글 저장.
     */
    public void insertBoard(BoardVO param, List<FileVO> filelist, String[] fileno) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        
        try {
            if (param.getBrdno() == null || "".equals(param.getBrdno())) {
                 session.insert(NAMESPACE+"insertBoard", param);
            } else {
                session.update(NAMESPACE+"updateBoard", param);
            }
            
            if (fileno != null) {
                HashMap<String, String[]> fparam = new HashMap<String, String[]>();
                fparam.put("fileno", fileno);
                session.insert(NAMESPACE+"deleteBoardFile", fparam);
            }
            
            for (FileVO f : filelist) {
                f.setParentPK(param.getBrdno());
                session.insert(NAMESPACE+"insertBoardFile", f);
            }
            txManager.commit(status);
        } catch (TransactionException ex) {
            txManager.rollback(status);
            System.out.println("데이터 저장 오류: " + ex.toString());
        }            
    }
 
    public BoardVO selectBoardOne(String param) {
        return session.selectOne(NAMESPACE+"selectBoardOne", param);
    }
    
    public void updateBoardRead(String param) {
        session.insert(NAMESPACE+"updateBoardRead", param);
    }
    
    public void deleteBoardOne(String param) {
        session.delete(NAMESPACE+"deleteBoardOne", param);
    }
    
    public List<?> selectBoardFileList(String param) {
        return session.selectList(NAMESPACE+"selectBoardFileList", param);
    }
    
    /* =============================================================== */
    public List<?> selectBoardReplyList(String param) {
        return session.selectList(NAMESPACE+"selectBoardReplyList", param);
    }
    
    /**
     * 댓글 저장. 
     */
    public void insertBoardReply(BoardReplyVO param) {
        if (param.getReno() == null || "".equals(param.getReno())) {
            if (param.getReparent() != null) {
                BoardReplyVO replyInfo = session.selectOne(NAMESPACE+"selectBoardReplyParent", param.getReparent());
                param.setRedepth(replyInfo.getRedepth());
                param.setReorder(replyInfo.getReorder() + 1);
                session.selectOne(NAMESPACE+"updateBoardReplyOrder", replyInfo);
            } else {
                Integer reorder = session.selectOne(NAMESPACE+"selectBoardReplyMaxOrder", param.getBrdno());
                param.setReorder(reorder);
            }
            
            session.insert(NAMESPACE+"insertBoardReply", param);
        } else {
            session.insert(NAMESPACE+"updateBoardReply", param);
        }
    }   
    
    /**
     * 댓글 삭제.
     * 자식 댓글이 있으면 삭제 안됨. 
     */
    public boolean deleteBoardReply(String param) {
        Integer cnt = session.selectOne(NAMESPACE+"selectBoardReplyChild", param);
        
        if ( cnt > 0) {
            return false;
        }
        
        session.update(NAMESPACE+"updateBoardReplyOrder4Delete", param);
        
        session.delete(NAMESPACE+"deleteBoardReply", param);
        
        return true;
    }

	
	
}
