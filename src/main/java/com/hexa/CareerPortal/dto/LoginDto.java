package com.hexa.CareerPortal.dto;
public class LoginDto {
	private String email;
	private String password;
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [email=" + email + ", password=" + password + "]";
	}
	
}