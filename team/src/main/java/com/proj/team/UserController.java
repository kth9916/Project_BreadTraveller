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
	// 1. Login ��ũ ������ ��
	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
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
	
	// 4. ȸ������ ������ �̵�
	@RequestMapping (value = "/register", method = RequestMethod.GET)
	public String register() {
		
		return "register";
	}
	
	// 5. ȸ������
	@RequestMapping (value = "/register", method = RequestMethod.POST)
	public String registerPost(UserDTO dto) {
		
		try {
			userService.insertUser(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	//�̸��� ����
	@RequestMapping(value ="/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		
		//��κ��� �Ѿ�� ������ Ȯ��
		logger.info("�̸��� ������ ���� Ȯ��");
		logger.info("������ȣ : " + email);
		
		//������ȣ (����) ����
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("������ȣ"+ checkNum);
		
		String title ="test ���� ȸ������ ����";
		String content = "���� �׽�Ʈ ����"
				+ "<br><br>"
				+ "���� ��ȣ�� " + checkNum + "�Դϴ�."
						+ "<br>"
						+ "�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���";
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
