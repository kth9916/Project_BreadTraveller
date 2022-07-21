package com.proj.team.bread.dao;

import com.proj.team.bread.domain.SearchCondition;
import com.proj.team.bread.domain.TourDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourDaoImpl implements TourDao {

    @Autowired
    SqlSession session;

    private static String namespace = "com.proj.team.dao.TourMapper.";

    @Override
    public List<TourDto> selectAll(){
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public int regionCount(String address){return session.selectOne(namespace+"regionCount",address);}
    
    @Override
    public List<TourDto> regions(SearchCondition sc){
        return session.selectList(namespace+"test",sc);
    }
    @Override
    public TourDto read(Integer no){
        return session.selectOne(namespace+"read",no);
    }
    @Override
    public int viewCount(Integer no){
        return session.update(namespace+"viewCount",no);
    }

}
