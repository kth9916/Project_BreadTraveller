package com.proj.team.board.dao;

import java.util.List;
import java.util.Map;

import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.SearchCriteria;

public interface BoardDAO {
	
	public void write(BoardVO boardVO) throws Exception;
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	public int listCount(SearchCriteria scri) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void update(BoardVO boardVO) throws Exception;
	public void delete(int bno) throws Exception;
	public void insertFile(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	public void updateFile(Map<String, Object> map) throws Exception;
	public void boardHit(int bno) throws Exception;
}
