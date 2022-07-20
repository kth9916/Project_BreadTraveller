package com.proj.team.bread.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bread")
public class breadController {

    //빵 메인페이지
    @RequestMapping(method = RequestMethod.GET)
    public String breadMain(){
         return "bread/main";
    }

    //키워드... 할까?
    @RequestMapping(method = RequestMethod.GET,value = "/search")
    public String search() {
        return "bread/search";
    }


}
