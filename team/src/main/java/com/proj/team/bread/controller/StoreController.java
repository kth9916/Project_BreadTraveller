package com.proj.team.bread.controller;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proj.team.bread.domain.PageHandler;
import com.proj.team.bread.domain.SearchCondition;
import com.proj.team.bread.domain.StoreDto;
import com.proj.team.bread.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    //가게리스트
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model m, SearchCondition sc){

        int totalCnt = storeService.getCount(sc);
        m.addAttribute("totalCnt",totalCnt);
        PageHandler pageHandler = new PageHandler(sc,totalCnt);
        List<StoreDto> list = storeService.getList(sc);
        m.addAttribute("list",list);
        m.addAttribute("ph",pageHandler);
        Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        return "bread/breadStore";
    }
    

    //가게상세페이지
    @RequestMapping(method = RequestMethod.GET, value ="/read" )
        public String storeRead(Integer id, Model model,HttpServletRequest request){
            StoreDto storeDto = storeService.getStore(id);
            String before_address = request.getHeader("referer");
            if(storeDto==null){
                return "redirect:/store/list";
            }
            model.addAttribute("storeDto",storeDto);
            model.addAttribute("before",before_address);
            return "bread/store";
        }





}
