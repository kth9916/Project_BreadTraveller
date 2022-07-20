package com.proj.team.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.proj.team.user.dao.UserDAO;
import com.proj.team.user.domain.UserDTO;


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
	
	@Override
	public int check(String u_id)throws Exception {
		return userDAO.check(u_id);
	}
	
	@Override
	public UserDTO select(UserDTO dto) throws Exception{
		return userDAO.select(dto);
	}
	
	@Override
	public int checknaver(String u_email)throws Exception{
		return userDAO.checknaver(u_email);
	}
	@Override
	public List<UserDTO> selectAll(UserDTO dto) throws Exception{
		return userDAO.selectAll(dto);
		
	}
	
	@Override
	public UserDTO selectId(String u_id) throws Exception{
		return userDAO.selectId(u_id);
	}
}
