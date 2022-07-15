package com.proj.team.board.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proj.team.board.service.FreeBoardService;
import com.proj.team.domain.UserDTO;
import com.proj.team.service.UserService;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
	
	@Autowired
	FreeBoardService freeBoardService;
	
	// 1. FreeBoard 링크 눌렀을 때
	@RequestMapping (value = "/list", method = RequestMethod.GET)
	public String boardList(HttpServletRequest request) {
		logger.info("FreeBoardList");
		return "board/list";		//jsp
	}
	
	// 2. 글쓰기
	@RequestMapping (value = "/write", method =RequestMethod.GET)
	public String writeBoard(HttpServletRequest request) {
		logger.info("FreeBoardWrite");
		return "board/write";
	}
	
	@RequestMapping (value = "/write/submit", method =RequestMethod.POST)
	public String writeBoardSubmit(HttpServletRequest request) {
		logger.info("FreeBoardWrite");
		return "board/list";
	}
}
