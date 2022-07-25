package com.proj.team.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj.team.board.common.FileUtil;
import com.proj.team.board.domain.BoardReplyVO;
import com.proj.team.board.domain.BoardVO;
import com.proj.team.board.domain.FileVO;
import com.proj.team.board.domain.SearchVO;
import com.proj.team.board.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard/*")
public class FreeBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
	
	 @Autowired
	    private FreeBoardService boardSvc;
	    
	 
	 /**
	  * 리스트
	  * @param searchVO
	  * @param modelMap
	  * @return
	 * @throws Exception 
	  */
	 @RequestMapping(value = "/boardList")
	    public String boardList(SearchVO searchVO, ModelMap modelMap) throws Exception {
		  
	        if (searchVO.getBgno() == null) {
	            searchVO.setBgno("1"); 
	        }
	        searchVO.pageCalculate( boardSvc.selectBoardCount(searchVO) ); // startRow, endRow

	        List<?> listview  = boardSvc.selectBoardList(searchVO);
	        
	        modelMap.addAttribute("listview", listview);
	        modelMap.addAttribute("searchVO", searchVO);
	        
	        return "board/BoardList";
	    }
	    
	    /** 
	     * 글 쓰기. 
	     * @throws Exception 
	     */
	    @RequestMapping(value = "/boardForm")
	    public String boardForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
	    	 String bgno = request.getParameter("bgno");
	         String brdno = request.getParameter("brdno");
	         if (brdno != null) {
	             BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
	             List<?> listview = boardSvc.selectBoardFileList(brdno);
	         
	             modelMap.addAttribute("boardInfo", boardInfo);
	             modelMap.addAttribute("listview", listview);
	             bgno = boardInfo.getBgno();
	         }
	         modelMap.addAttribute("bgno", bgno);
	        
	        return "board/BoardForm";
	    }
	    
	    /**
	     * 글 저장.
	     * @throws Exception 
	     */
	    @RequestMapping(value = "/boardSave")
	    public String boardSave(HttpServletRequest request, BoardVO boardInfo) throws Exception {
	    	String[] fileno = request.getParameterValues("fileno");
	        
	        FileUtil fs = new FileUtil();
	        List<FileVO> filelist = fs.saveAllFiles(boardInfo.getUploadfile());

	        boardSvc.insertBoard(boardInfo, filelist, fileno);


	        return "redirect:/boardList?bgno=" + boardInfo.getBgno();
	    }

	    /**
	     * 글 읽기.
	     * @throws Exception 
	     */
	    @RequestMapping(value = "/boardRead")
	    public String boardRead(HttpServletRequest request, ModelMap modelMap) throws Exception {
	        
	    	String brdno = request.getParameter("brdno");
	        
	        boardSvc.updateBoardRead(brdno);
	        BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
	        List<?> listview = boardSvc.selectBoardFileList(brdno);
	        List<?> replylist = boardSvc.selectBoardReplyList(brdno);
	        
	        modelMap.addAttribute("boardInfo", boardInfo);
	        modelMap.addAttribute("listview", listview);
	        modelMap.addAttribute("replylist", replylist);
	        
	        return "board/BoardRead";
	    }
	    
	    /**
	     * 글 삭제.
	     * @throws Exception 
	     */
	    @RequestMapping(value = "/boardDelete")
	    public String boardDelete(HttpServletRequest request) throws Exception {
	    	String brdno = request.getParameter("brdno");
	        String bgno = request.getParameter("bgno");
	        
	        boardSvc.deleteBoardOne(brdno);
	        
	        return "redirect:/boardList?bgno=" + bgno;
	    }

	    /* ===================================================================== */
	    
	    /**
	     * 댓글 저장.
	     * @throws Exception 
	     */
	    @RequestMapping(value = "/boardReplySave")
	    public String boardReplySave(HttpServletRequest request, BoardReplyVO boardReplyInfo, ModelMap modelMap) throws Exception {
	        
	    	boardSvc.insertBoardReply(boardReplyInfo);

	        modelMap.addAttribute("replyInfo", boardReplyInfo);
	        
	        return "board/BoardReadAjax4Reply";        
	    }
	    
	    /**
	     * 댓글 삭제.
	     * @throws Exception 
	     */
	    @RequestMapping(value = "/boardReplyDelete")
	    public void boardReplyDelete(HttpServletResponse response, BoardReplyVO boardReplyInfo) throws Exception {
	        
	    	 ObjectMapper mapper = new ObjectMapper();
	         response.setContentType("application/json;charset=UTF-8");
	         
	         try {
	             if (!boardSvc.deleteBoardReply(boardReplyInfo.getReno()) ) {
	                 response.getWriter().print(mapper.writeValueAsString("Fail"));
	             } else {
	                 response.getWriter().print(mapper.writeValueAsString("OK"));
	             }
	         } catch (IOException ex) {
	             System.out.println("오류: 댓글 삭제에 문제가 발생했습니다.");
	         }
	    }
	
	
	
	
	
	
}
