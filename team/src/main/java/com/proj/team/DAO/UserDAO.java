package com.proj.team.DAO;

import com.proj.team.DTO.UserDTO;

public interface UserDAO {

	int selectUserDTO(UserDTO dto) throws Exception;
	
}
