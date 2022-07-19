package com.proj.team.dao;

import java.util.List;

import com.proj.team.domain.SearchCondition;
import com.proj.team.domain.StoreDto;

public interface StoreDao {
    List<StoreDto> selectAll() throws Exception;

    List<StoreDto> Region(String address);

    StoreDto selectOne(Integer id);

    List<StoreDto> selectResultPage(SearchCondition sc);

    List<StoreDto> selectAllPage(SearchCondition sc);
    int count(SearchCondition sc);

    List<StoreDto> selectPop(SearchCondition sc);

    }


