package com.proj.team;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proj.team.domain.UserDTO;
import com.proj.team.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
		
	@Autowired
	JavaMailSender mailSender;
<<<<<<< HEAD
	// 1. Login ¸µÅ© ´­·¶À» ¶§
=======
	// 1. Login ë§í¬ ëˆŒë €ì„ ë•Œ
>>>>>>> gyh
	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		return "login";
	}
	
<<<<<<< HEAD
	// 2. Login Æû¿¡¼­ Àü¼Û ÇßÀ» ¶§
=======
	// 2. Login í¼ì—ì„œ ì „ì†¡ í–ˆì„ ë•Œ
>>>>>>> gyh
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public String login(UserDTO dto, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) {
		
		try {
			UserDTO user = userService.login(dto);
			if(user==null) {
<<<<<<< HEAD
				rttr.addFlashAttribute("msg","id ¶Ç´Â password°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
=======
				rttr.addFlashAttribute("msg","id ë˜ëŠ” passwordê°€ ì¼ì¹˜í•˜ì§€ ì•ŠìŠµë‹ˆë‹¤.");
>>>>>>> gyh
				
				return "redirect:/user/login";
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("u_id", user.getU_id());
				session.setAttribute("u_pass", user.getU_pass());
				
				if(rememberId) {
					Cookie cookie = new Cookie("u_id",user.getU_id());
					response.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie("u_id",user.getU_id());
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
<<<<<<< HEAD
				System.out.println("·Î±×ÀÎ ¼º°ø");
=======
				System.out.println("ë¡œê·¸ì¸ ì„±ê³µ");
>>>>>>> gyh
			}
		}catch(Exception e) {
			
		}
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		return "redirect:" + toURL;		
		
	}
	
<<<<<<< HEAD
	// 3. ·Î±×¾Æ¿ô
=======
	// 3. ë¡œê·¸ì•„ì›ƒ
>>>>>>> gyh
	@RequestMapping (value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
<<<<<<< HEAD
	// 4. È¸¿ø°¡ÀÔ ÆäÀÌÁö ÀÌµ¿
=======
	// 4. íšŒì›ê°€ì… í˜ì´ì§€ ì´ë™
>>>>>>> gyh
	@RequestMapping (value = "/register", method = RequestMethod.GET)
	public String register() {
		
		return "register";
	}
	
<<<<<<< HEAD
	// 5. È¸¿ø°¡ÀÔ
=======
	// 5. íšŒì›ê°€ì…
>>>>>>> gyh
	@RequestMapping (value = "/register", method = RequestMethod.POST)
	public String registerPost(UserDTO dto) {
		
		try {
			userService.insertUser(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
<<<<<<< HEAD
	//ÀÌ¸ŞÀÏ Àü¼Û
=======
	//ì´ë©”ì¼ ì „ì†¡
>>>>>>> gyh
	@RequestMapping(value ="/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		
<<<<<<< HEAD
		//ºä·ÎºÎÅÍ ³Ñ¾î¿Â µ¥ÀÌÅÍ È®ÀÎ
		logger.info("ÀÌ¸ŞÀÏ µ¥ÀÌÅÍ Àü¼Û È®ÀÎ");
		logger.info("ÀÎÁõ¹øÈ£ : " + email);
		
		//ÀÎÁõ¹øÈ£ (³­¼ö) »ı¼º
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("ÀÎÁõ¹øÈ£"+ checkNum);
		
		String title ="test ¸ŞÀÏ È¸¿ø°¡ÀÔ ÀÎÁõ";
		String content = "¸ŞÀÏ Å×½ºÆ® ³»¿ë"
				+ "<br><br>"
				+ "ÀÎÁõ ¹øÈ£´Â " + checkNum + "ÀÔ´Ï´Ù."
						+ "<br>"
						+ "ÇØ´ç ÀÎÁõ¹øÈ£¸¦ ÀÎÁõ¹øÈ£ È®ÀÎ¶õ¿¡ ±âÀÔÇÏ¿© ÁÖ¼¼¿ä";
=======
		//ë·°ë¡œë¶€í„° ë„˜ì–´ì˜¨ ë°ì´í„° í™•ì¸
		logger.info("ì´ë©”ì¼ ë°ì´í„° ì „ì†¡ í™•ì¸");
		logger.info("ì¸ì¦ë²ˆí˜¸ : " + email);
		
		//ì¸ì¦ë²ˆí˜¸ (ë‚œìˆ˜) ìƒì„±
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("ì¸ì¦ë²ˆí˜¸"+ checkNum);
		
		String title ="test ë©”ì¼ íšŒì›ê°€ì… ì¸ì¦";
		String content = "ë©”ì¼ í…ŒìŠ¤íŠ¸ ë‚´ìš©"
				+ "<br><br>"
				+ "ì¸ì¦ ë²ˆí˜¸ëŠ” " + checkNum + "ì…ë‹ˆë‹¤."
						+ "<br>"
						+ "í•´ë‹¹ ì¸ì¦ë²ˆí˜¸ë¥¼ ì¸ì¦ë²ˆí˜¸ í™•ì¸ë€ì— ê¸°ì…í•˜ì—¬ ì£¼ì„¸ìš”";
>>>>>>> gyh
		String setFrom ="modddl96@naver.com";
		String toMail = email;
		
		try {
	            
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
	            helper.setFrom(setFrom);
	            helper.setTo(toMail);
	            helper.setSubject(title);
	            helper.setText(content,true);
	            
	            mailSender.send(message);
	            
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		
			String num = Integer.toString(checkNum);
			
			return num;
	}
}
