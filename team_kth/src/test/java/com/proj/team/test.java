package com.proj.team;


import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.proj.team.dao.UserDAO;
import com.proj.team.domain.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class test {

	
	@Autowired
	UserDAO userDAO;
	
	
	@Test
	public void selectAll() throws Exception {
		List<UserDTO> list = userDAO.selectAll();
		System.out.println(list);
	}

	@Test
	public void select() throws Exception {
		UserDTO dto = new UserDTO();
		dto.setU_id("a");
		dto.setU_pass("a");
				
		System.out.println(dto);
		UserDTO dto2 = userDAO.login(dto);
		System.out.println(dto2);
		assertTrue(dto2.equals(dto));

	}
	

	
}
