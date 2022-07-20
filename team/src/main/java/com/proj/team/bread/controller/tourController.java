package com.proj.team.bread.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj.team.bread.domain.PageHandler;
import com.proj.team.bread.domain.SearchCondition;
import com.proj.team.bread.domain.StoreDto;
import com.proj.team.bread.domain.TourDto;
import com.proj.team.bread.service.StoreService;
import com.proj.team.bread.service.TourService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tour")
public class tourController {

    @Autowired
    StoreService storeService;

    @Autowired
    TourService tourService;

    //지도 클릭 > 지역별 리스트 출력 (페이징o)
    @RequestMapping(method = RequestMethod.GET,value = "/region")
    public String breadMap(@RequestParam(value = "address", required = false) String address, SearchCondition sc ,Model m)throws Exception {
        if(address==null){
            return "bread/regionTour";
        }
        System.out.println("address:"+address);
        int totalCnt = tourService.regionGetCount(address);
        m.addAttribute("totalCnt",totalCnt);
        PageHandler pageHandler = new PageHandler(sc,totalCnt);
        m.addAttribute("ph",pageHandler);
        sc.setType(address);
        List<TourDto> list = tourService.regions(sc);
        System.out.println(list);
        m.addAttribute("list",list);
        Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        return "bread/regionTour";
    }

    //api이용 루트 출력
    @RequestMapping(method = RequestMethod.GET, value = "/map/{no}")
    public String breadTourApi(@PathVariable Integer no,Model m) throws JsonProcessingException {
        System.out.println(no);
        TourDto tourDto = tourService.getRead(no);
        m.addAttribute("tourDto",tourDto);
        StoreDto start = storeService.getStore(tourDto.getStartPoint()); //출발점 dto
        m.addAttribute("start",start);
        StoreDto end = storeService.getStore(tourDto.getEndPoint()); //도작점dto
        m.addAttribute("end",end);
        String way = tourDto.getWayPoint(); //경유지 dto
        String jsonArr = "[{\"id\":3},{\"id\":4}]"; //test로
        ObjectMapper objectMapper = new ObjectMapper();
        List<StoreDto> wayStore = objectMapper.readValue(jsonArr, new TypeReference<List<StoreDto>>() {});
        double[] latArr = new double[wayStore.size()];
        double[] lonArr = new double[wayStore.size()];
        for(int i=0; i<wayStore.size(); i++){
         StoreDto dto = storeService.getStore(wayStore.get(i).getId());
          latArr[i] = dto.getLat();
          lonArr[i] = dto.getLon();
        }
        m.addAttribute("latArr",latArr);
        m.addAttribute("lonArr",lonArr);
        m.addAttribute("wayStore",wayStore);
        m.addAttribute("way",way);
        return "bread/tourApi";
    }

    //투어 등록 페이지 보여주기
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register (Model m) throws Exception {
        return "bread/tourAdd";
    }

    //팝업
    @RequestMapping(value = "/popup/{type}" , method = RequestMethod.GET)
    public String popUp(@PathVariable String type, Model m) throws Exception {
        //페이징 + 검색 조건 처리되는 리스트 불러오기
    	m.addAttribute("type",type);
        List<StoreDto> store = storeService.AllStore();
        m.addAttribute("store",store);
        return "bread/popup";
    }












}
