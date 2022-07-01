package com.proj.team.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.DTO.UserDTO2;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SqlSession session;
	
	private static String namespace ="com.proj.team.DAO.UserMapper.";
	
	@Override
	public int selectUserDTO(UserDTO2 dto) throws Exception {
		System.out.println(dto.getU_id());
		System.out.println(dto.getU_pass());
		
		return session.selectOne(namespace+"selectUser",dto);
		
	}

}
