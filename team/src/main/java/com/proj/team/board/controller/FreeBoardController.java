package com.proj.team.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proj.team.board.domain.FreeBoardVO;
import com.proj.team.board.domain.Pagination;
import com.proj.team.board.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
	
	@Autowired
	FreeBoardService freeBoardService;
	
	//FreeBoard 링크 눌렀을 때
	@RequestMapping (value = "/list.action", method = RequestMethod.GET)
	public String boardList(Model model,
			@RequestParam(required=false,defaultValue="1")int page,
			@RequestParam(required=false,defaultValue="1")int range
			) throws Exception{
		
			//전체 게시글 개수
			int listCnt = freeBoardService.getBoardListCnt();
			
			//페이징 정보 세팅
			Pagination pagination = new Pagination();
			pagination.pageInfo(page, range, listCnt);
			
			model.addAttribute("pagination",pagination);
			model.addAttribute("boardList",freeBoardService.selectList(pagination));
			return "board/freeboardlist";
	}
	
	//글 읽어오기
	@RequestMapping (value = "/read.action", method = RequestMethod.GET)
	public String read(@RequestParam("f_no")int f_no, Model model) throws Exception {
		logger.info("FreeBoardRead");
		
		model.addAttribute("boardContent",freeBoardService.read(f_no));
		return "board/freeboardread";		
	}
	
	
	//글쓰기
	@RequestMapping (value = "/write.action", method =RequestMethod.GET)
	public String writeForm() {
		logger.info("FreeBoardWrite");
		
		return "board/freeboardwrite";
	}
	
	//글 쓰기 제출
	@RequestMapping (value = "/save.action ", method =RequestMethod.POST)
	public String writeSubmit(@ModelAttribute("FreeBoardVO")FreeBoardVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("FreeBoardWrite");
		freeBoardService.insert(vo);

		return "redirect:list.action";
	}
	
	//수정
	@RequestMapping(value = "/update.action", method =RequestMethod.GET)
	public String modify(@RequestParam("f_no") int f_no, @RequestParam("mode") String mode, Model model) throws Exception{
		logger.info("FreeBoardEdit");
		model.addAttribute("boardContent", freeBoardService.read(f_no));
		model.addAttribute("mode", mode);
		model.addAttribute("freeBoardVO",new FreeBoardVO());
		
		return "board/freeboardedit";
	}
	
	//수정 저장
	@RequestMapping(value="/updatesave.action", method=RequestMethod.POST)
	public String updateSave(@ModelAttribute("FreeBoardVO") FreeBoardVO vo,RedirectAttributes rttr) throws Exception{
		freeBoardService.update(vo);
		return "redirect:list.action";
	}
	
	//삭제
	@RequestMapping(value = "/delete.action", method =RequestMethod.GET)
	public String delete(RedirectAttributes rttr, @RequestParam("f_no") int f_no) throws Exception{
		freeBoardService.delete(f_no);
		return "redirect:list.action";
	}
	
	
}
