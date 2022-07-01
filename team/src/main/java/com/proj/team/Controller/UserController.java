package com.proj.team.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proj.team.DTO.UserDTO;
import com.proj.team.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@SuppressWarnings("null")
	@RequestMapping(value ="/login", method = RequestMethod.POST)
		public String userCheck(UserDTO dto) {
				HttpSession session = null;
				String path ="";
				String u_id = dto.getU_id();
				try {
					
				int result = userService.getUser(dto);
				
					if (result == 1 ) {
						session.setAttribute("u_id", u_id);
						path ="home";
						
					}else {
						path ="index";
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				return path;
			
	}
	
}
