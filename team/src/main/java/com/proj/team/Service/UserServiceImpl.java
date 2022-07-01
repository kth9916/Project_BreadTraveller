package com.proj.team.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.team.DAO.UserDAO;
import com.proj.team.DTO.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	
	@Override
	public int getUser(UserDTO dto) throws Exception {
		return userDao.selectUserDTO(dto);
	}

}
