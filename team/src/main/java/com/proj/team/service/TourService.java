package com.proj.team.service;

import java.util.List;
import com.proj.team.domain.SearchCondition;
import com.proj.team.domain.TourDto;

public interface TourService {

    List<TourDto> regions(SearchCondition sc); //지역별 리스트 페이징중
    int regionGetCount(String address); //지역별 출력 갯수
    List<TourDto> allTour(); //전체투어출력
    TourDto getRead(Integer no);//투어1개 읽기


    }
