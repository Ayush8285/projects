package com.ayush.chatapp.dto;

public class UserDTO {
	private String userid;
//	private char[] password;
	private String password;
	public UserDTO(String userid , String password) {
		this.userid = userid;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
