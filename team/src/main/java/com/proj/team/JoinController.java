package com.proj.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {

	@Autowired
	private MybatisDAO mybatisDAO;
	
	@RequestMapping("joinList2.do")
	public String selectList2(End_VO vo, Model model) {
		System.out.println("컨트롤러 호출 서옹 joinList2.do"); 
		List<End_VO> joinList = mybatisDAO.selectListJoin2(vo);
		
		System.out.println("mybatis를 통한 list객체저장 성공");
		
		
		model.addAttribute("joinList",joinList);
		
		return "joinList2.jsp";
	}
}
