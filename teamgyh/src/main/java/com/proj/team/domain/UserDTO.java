package com.proj.team.domain;

import java.util.Objects;

public class UserDto {
	
	private String u_id;
	private String u_pass;
	
	public UserDto(String u_id, String u_pass) {
		this.u_id = u_id;
		this.u_pass = u_pass;
	}
	public UserDto() {}
	
	
	public String getU_Id() {
		return u_id;
	}
	public void setU_Id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_Pass() {
		return u_pass;
	}
	public void setU_Pass(String u_pass) {
		this.u_pass = u_pass;
	}
	
	@Override
	public String toString() {
		return "UserDto [u_id=" + u_id + ", u_pass=" + u_pass + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(u_id, u_pass);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(u_id, other.u_id) && Objects.equals(u_pass, other.u_pass);
	}

	
	


}
