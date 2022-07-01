package com.proj.team;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.team.DAO.UserDAO;
import com.proj.team.DTO.UserDTO2;

public class Test01 {


	@Autowired
	UserDAO userDAO;
	
	@Test
	public void test1() throws Exception {
		UserDTO2 dto = new UserDTO2("aaa","aaa");
		assertTrue(userDAO.selectUserDTO(dto) == 1);
		
		if(userDAO.selectUserDTO(dto) == 1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
}
