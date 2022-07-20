package com.proj.team.bread.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.team.bread.dao.StoreDao;
import com.proj.team.bread.domain.SearchCondition;
import com.proj.team.bread.domain.StoreDto;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreDao storeDao;

    @Override //시,도별 가게
    public List<StoreDto> regionStore(String address){
        return storeDao.Region(address);
    }

    @Override //전체가게 출력 페이징 x 
    public List<StoreDto>AllStore() throws Exception {
        return storeDao.selectAll();
    }

    @Override //가게 1개 출력
    public StoreDto getStore(Integer id){
        return storeDao.selectOne(id);
    }


    @Override //1page > 10개 출력 + 검색조건
    public List<StoreDto> getList(SearchCondition sc) {
        if(sc.getKeyword()==null && sc.getType()==null){
            return storeDao.selectAllPage(sc);
        }else{
            return storeDao.selectResultPage(sc);
        }
    }
    @Override
    public int getCount(SearchCondition sc){
        return storeDao.count(sc);
    }
}
