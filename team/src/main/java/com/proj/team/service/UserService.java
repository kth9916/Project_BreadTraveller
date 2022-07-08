package com.proj.team.service;

import com.proj.team.domain.UserDTO;

public interface UserService {
	UserDTO login(UserDTO dto) throws Exception;
	
	void insertUser(UserDTO dto) throws Exception;
	
	int check(String u_id) throws Exception;
	
	UserDTO select(UserDTO dto) throws Exception;
	
	int checknaver(String u_email) throws Exception;
}
