package com.proj.team;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.proj.team.DAO.UserDAO;
import com.proj.team.DTO.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/ebapp/WEB-INF/spring/root-context.xml"})
public class test {

	@Autowired
	UserDAO userDAO;
	
	@Test
	public void test1() throws Exception {
		UserDTO dto = new UserDTO(1,"aaaa","aaaa","aaaa","1","1234","aaaa","aaaa","aaaa","hong","sample.jpg",0,0,"sysdate","hong","bbbb","bbbb");
		assertTrue(userDAO.selectUserDTO(dto) == 1);
		
	}
}
