package com.proj.team.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.proj.team.dao.UserDAO;
import com.proj.team.domain.UserDTO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserDTO login(UserDTO dto) throws Exception {
		return userDAO.login(dto);
	}
	
	@Override
	public void insertUser(UserDTO dto) throws Exception{
		userDAO.insertUser(dto);
	}
}
