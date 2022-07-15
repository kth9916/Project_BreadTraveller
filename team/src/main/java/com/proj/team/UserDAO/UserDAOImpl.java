package com.proj.team.UserDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.team.UserDTO.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession session;
	
    private static String namespace = "com.proj.team.dao.UserMapper.";
    
    @Override
	public List<UserDTO> selectAll(UserDTO dto){
    	return session.selectList(namespace+"selectAll");
    }
    
    
	@Override
    public UserDTO select(UserDTO dto) {
    	return session.selectOne(namespace+"select",dto);
    }
	
	@Override
	public int check(String u_id) throws Exception {
		return session.selectOne(namespace +"check",u_id);
	}


	@Override
	public UserDTO login(UserDTO dto) throws Exception {
		return session.selectOne(namespace + "login",dto);
	}

	@Override
	public void insertUser(UserDTO dto) throws Exception {
		session.insert(namespace + "insertUser",dto);
		
	}
	
	@Override
	public int checknaver(String u_email)throws Exception{
		return session.selectOne(namespace+"checknaver",u_email);
	}
	
	@Override
	public UserDTO selectId(String u_id)throws Exception{
		return session.selectOne(namespace +"selectId",u_id);
	}
	
	@Override
	public void deleteUser(String u_num)throws Exception{
		session.selectOne(namespace+"deleteUser",u_num);
	}
}
