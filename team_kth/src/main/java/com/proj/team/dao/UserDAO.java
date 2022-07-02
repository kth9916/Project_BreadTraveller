package com.proj.team.dao;

import java.util.List;


import com.proj.team.domain.UserDTO;

public interface UserDAO {

	List<UserDTO> selectAll() throws Exception;

	UserDTO select(String u_id) throws Exception;
	
	int count() throws Exception;
	
	UserDTO login(UserDTO dto) throws Exception;

}