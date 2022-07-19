package com.proj.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.team.dao.TourDao;
import com.proj.team.domain.SearchCondition;
import com.proj.team.domain.TourDto;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourDao tourDao;

    @Override
    public List<TourDto> regions(SearchCondition sc) {
        return tourDao.regions(sc);
    }

    @Override
    public int regionGetCount(String address){return tourDao.regionCount(address);}

    @Override
    public List<TourDto> allTour(){
        return tourDao.selectAll();
    }

    @Override
    public TourDto getRead(Integer no){
        tourDao.viewCount(no);
        return tourDao.read(no);
    }

}
