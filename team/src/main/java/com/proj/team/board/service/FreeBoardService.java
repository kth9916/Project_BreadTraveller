package com.proj.team.board.service;

import java.util.List;

import com.proj.team.board.domain.BoardReplyVO;
import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.FileVO;
import com.proj.team.board.domain.SearchVO;

public interface FreeBoardService {


	public Integer selectBoardCount(SearchVO vo) throws Exception;
	public List<?>selectBoardList(SearchVO vo) throws Exception;
	public void insertBoard(BoardVO vo, List<FileVO> filelist, String[] fileno) throws Exception;
	public BoardVO selectBoardOne(String param) throws Exception;
	public void updateBoardRead(String param) throws Exception;
	public void deleteBoardOne(String param) throws Exception;
	public List<?> selectBoardFileList(String param) throws Exception;
	public List<?> selectBoardReplyList(String param) throws Exception;
	public void insertBoardReply(BoardReplyVO vo) throws Exception;
	public boolean deleteBoardReply(String param) throws Exception;
	
}
