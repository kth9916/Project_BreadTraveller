package com.proj.team.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proj.team.DTO.UserDTO2;
import com.proj.team.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@SuppressWarnings("null")
	@RequestMapping(value ="/login", method = RequestMethod.POST)
		public String userCheck(UserDTO2 dto) {
				HttpSession session = null;
				String path ="";
				
				try {
					
					
				int result = userService.getUser(dto);
				
					if (result == 1 ) {
						session.setAttribute("u_id", dto.getU_id());
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
