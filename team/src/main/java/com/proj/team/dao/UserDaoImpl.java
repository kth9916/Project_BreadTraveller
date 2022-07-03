package com.proj.team.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.domain.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SqlSession session;
	
    private static String namespace = "com.proj.team.dao.UserMapper.";
    
    @Override
	public List<UserDto> selectAll(){
    	return session.selectList(namespace+"selectAll");
    }
    
    
	@Override
    public UserDto select(UserDto dto) {
    	return session.selectOne(namespace+"select",dto);
    }


}
