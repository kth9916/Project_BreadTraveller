package com.proj.team;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proj.team.domain.UserDTO;
import com.proj.team.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
		
	// 1. Login ��ũ ������ ��
	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		if(request.getSession(false)!=null) {
			request.getSession(false).invalidate();
		}
		return "login";
	}
	
	// 2. Login ������ ���� ���� ��
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public String login(UserDTO dto, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) {
		
		try {
			UserDTO user = userService.login(dto);
			if(user==null) {
				rttr.addFlashAttribute("msg","id �Ǵ� password�� ��ġ���� �ʽ��ϴ�.");
				
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
				System.out.println("�α��� ����");
			}
		}catch(Exception e) {
			
		}
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		return "redirect:" + toURL;		
		
	}
	
	// 3. �α׾ƿ�
	@RequestMapping (value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
