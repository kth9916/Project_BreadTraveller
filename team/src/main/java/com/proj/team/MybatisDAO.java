package com.proj.team;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	

	public List<End_VO> selectListJoin2 (End_VO vo){
		System.out.println("selectListJoin2() 메소드 호출");
		return mybatis.selectList("Join.selectListJoin2",vo);
	}

	
}
