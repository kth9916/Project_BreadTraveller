package com.proj.team.UserDAO;

import java.util.List;

import com.proj.team.UserDTO.UserDTO;
import com.proj.team.util.PagingVO;

public interface UserDAO{

	List<UserDTO> selectAll(UserDTO dto) throws Exception;

	UserDTO select(UserDTO dto) throws Exception;

	int check(String u_id) throws Exception;
	
	UserDTO login(UserDTO dto) throws Exception;
	
	void insertUser(UserDTO dto) throws Exception;
	
	int checknaver(String u_email) throws Exception;
	
	UserDTO selectId(String u_id) throws Exception;
	
	void deleteUser(String u_num) throws Exception;
	
	public int countUser22();
	
	public List<UserDTO> selectUser22(PagingVO vo);
}