package com.village.farmer.model.response;

public class UserRegisterationResponse extends GenericsResponse {

	private String user;
	private String role;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
