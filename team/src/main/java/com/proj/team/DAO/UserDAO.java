package com.proj.team.dao;

import java.util.List;

import com.proj.team.domain.UserDto;

public interface UserDao {

	List<UserDto> selectAll();

	UserDto select(UserDto dto);


}