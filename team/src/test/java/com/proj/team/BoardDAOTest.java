package com.proj.team;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.proj.team.board.dao.FreeBoardDAO;
import com.proj.team.board.domain.FreeBoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"classpath:spring/root-context.xml",
		"classpath:spring/servlet-context.xml"
})
public class BoardDAOTest {
	
	@Autowired
	FreeBoardDAO dao;
	
	@Test
	public void testInsertBoard() throws Exception{
		FreeBoardVO vo = new FreeBoardVO();
		for(int i=1; i< 1234;i++) {
			vo.setF_title(i+"번째 게시물");
			vo.setF_content(i+"번째 게시물");
			dao.insert(vo);
		}
	}
}
