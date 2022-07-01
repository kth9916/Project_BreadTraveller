package com.proj.team.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.DTO.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SqlSession session;
	
	private static String namespace ="com.proj.team.DAO.UserMapper.";
	
	@Override
	public int selectUserDTO(UserDTO dto) throws Exception {
		return session.selectOne(namespace+"selectUser",dto);
	}

}
