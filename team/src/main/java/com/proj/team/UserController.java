package com.proj.team;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
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
	// 1. Login 링크 눌렀을 때
	@RequestMapping (value = "/login", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
		return "login";
	}
	
	// 2. Login 폼에서 전송 했을 때
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public String login(UserDTO dto, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) {
		
		try {
				UserDTO user = userService.login(dto);
					
				if(user==null) {
					rttr.addFlashAttribute("msg","id 또는 password가 일치하지 않습니다.");
					
					return "redirect:/user/login";
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("u_id", user.getU_id());
				
					if(rememberId) {
						Cookie cookie = new Cookie("u_id",user.getU_id());
						response.addCookie(cookie);
					}else {
						Cookie cookie = new Cookie("u_id",user.getU_id());
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					System.out.println("로그인 성공");
				}
		}catch(Exception e) {
			
		}
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		return "redirect:" + toURL;		
		
	}
	
	// 3. 로그아웃
	@RequestMapping (value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 4. 회원가입 페이지 이동
	@RequestMapping (value = "/register", method = RequestMethod.GET)
	public String register() {
		
		return "register";
	}
	
	// 5. 회원가입
	@RequestMapping (value = "/register", method = RequestMethod.POST)
	public String registerPost(UserDTO dto) {
		
		try {
			userService.insertUser(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	//이메일 전송
	@RequestMapping(value ="/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		
		//뷰로부터 넘어온 데이터 확인
		logger.info("이메일 데이터 전송 확인");
		logger.info("인증번호 : " + email);
		
		//인증번호 (난수) 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호"+ checkNum);
		
		String title ="test 메일 회원가입 인증";
		String content = "메일 테스트 내용"
				+ "<br><br>"
				+ "인증 번호는 " + checkNum + "입니다."
						+ "<br>"
						+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요";
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
	@RequestMapping(value="/ckid",method =RequestMethod.POST)
	public String ckid(String u_id, Model model) {
		int data = 0 ;
		try {
		
			data =	userService.check(u_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("data", data);
		
		return "idck";
	}
	
	@RequestMapping(value="/naver",method =RequestMethod.POST)
	public String navlogin(UserDTO dto) {
			try {
				userService.insertUser(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/";
		}
	
	@RequestMapping(value="/callback",method = RequestMethod.GET )
	public String callback() {
		
		return "callback";
		
	}
	@RequestMapping(value="/callback",method = RequestMethod.POST )
	public String callbackPost(HttpServletRequest req, String u_email) {
		int check = 0;
		System.out.println("1"+check);
		System.out.println(u_email);
		System.out.println(req.getParameter("u_email"));
		try {
			check = userService.checknaver(u_email);
			System.out.println(check);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("4"+check);
		return "callback";
		
	}
	
	@RequestMapping(value ="/List", method = RequestMethod.GET)
	public String getUserList(UserDTO dto, Model model, HttpSession session) throws Exception {
		//임시로 user 나중에 빵으로 변경
		model.addAttribute("userList",userService.selectAll(dto));
		
		String ss = (String) session.getAttribute("u_id");

		UserDTO dto2 =userService.selectId(ss);
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//String dateToStr = dateFormat.format(dto2.getU_date());
		//System.out.println(dateToStr);
		//Date date = dateFormat.parse(dateToStr);
		//System.out.println(date);
		//dto2.setU_date(dateToStr);
		//넣고 model로 값가져오기
		model.addAttribute("user",dto2);
		
		return "my";
	}
	@RequestMapping(value ="/update", method = RequestMethod.GET)
	public String update(UserDTO dto, Model model, HttpSession session) throws Exception {
		
		String ss = (String) session.getAttribute("u_id");

		UserDTO dto2 =userService.selectId(ss);
		
		model.addAttribute("user",dto2);
		return "update";
	}
	
	
	
}
