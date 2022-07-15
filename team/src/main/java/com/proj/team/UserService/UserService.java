package com.proj.team.UserService;

import java.util.List;

import com.proj.team.UserDTO.UserDTO;

public interface UserService {
	UserDTO login(UserDTO dto) throws Exception;
	
	void insertUser(UserDTO dto) throws Exception;
	
	int check(String u_id) throws Exception;
	
	UserDTO select(UserDTO dto) throws Exception;
	
	int checknaver(String u_email) throws Exception;
	
	List<UserDTO> selectAll(UserDTO dto) throws Exception;
	
	UserDTO selectId(String u_id) throws Exception;
	
	void deleteUser(String u_num) throws Exception;
}
