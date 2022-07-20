package com.proj.team.bread.dao;


import java.util.List;
import com.proj.team.bread.domain.SearchCondition;
import com.proj.team.bread.domain.TourDto;

public interface TourDao {
    List<TourDto> regions(SearchCondition sc);
    int regionCount(String address);
    List<TourDto> selectAll();
    TourDto read(Integer no);
    int viewCount(Integer no);


    }
