package com.proj.team.dao;


import java.util.List;
import com.proj.team.domain.SearchCondition;
import com.proj.team.domain.TourDto;

public interface TourDao {
    List<TourDto> regions(SearchCondition sc);
    int regionCount(String address);
    List<TourDto> selectAll();
    TourDto read(Integer no);
    int viewCount(Integer no);


    }
