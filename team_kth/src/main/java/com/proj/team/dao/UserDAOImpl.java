package com.proj.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.domain.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession session;
	
    private static String namespace = "com.proj.team.dao.UserMapper.";
    
    @Override
	public List<UserDTO> selectAll(){
    	return session.selectList(namespace+"selectAll");
    }
    
    
	@Override
    public UserDTO select(String u_id) throws Exception {
    	return session.selectOne(namespace+"select", u_id);
    }

	@Override
	public int count() throws Exception {
		return session.selectOne(namespace +"count");
	}


	@Override
	public UserDTO login(UserDTO dto) throws Exception {
		return session.selectOne(namespace + "login",dto);
	}


}
