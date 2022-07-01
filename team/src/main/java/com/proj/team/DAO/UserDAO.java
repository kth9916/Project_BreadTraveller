package com.proj.team.DAO;

import com.proj.team.DTO.UserDTO2;

public interface UserDAO {

	int selectUserDTO(UserDTO2 dto) throws Exception;
	
}
