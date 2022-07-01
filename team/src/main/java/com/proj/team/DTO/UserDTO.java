package com.proj.team.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

	private int u_num; 
	private String u_id;
	private String u_pass;
	private String email;
	private String grade;
	private String phone;
	private String nick;
	private String address;
	private String post;
	private String u_name;
	private String u_profile;
	private int point;
	private int apoint; 
	private String u_date;
	private String likes;
	private String question;
	private String answer;
	
	
	
}
