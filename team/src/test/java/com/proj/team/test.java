package com.proj.team;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.proj.team.dao.UserDao;
import com.proj.team.domain.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class test {

	
	@Autowired
	UserDao userDao;
	
	
	@Test
	public void selectAll() {
		List<UserDto> list =userDao.selectAll();
		System.out.println(list);
	}

	@Test
	public void select() {
		UserDto dto = new UserDto();
		dto.setU_Id("a");
		dto.setU_Pass("a");
				
		System.out.println("A"+dto);
		UserDto dto2 = userDao.select(dto);
		System.out.println(dto2);
		assertTrue(dto2.equals(dto));

	}
	

	
}
