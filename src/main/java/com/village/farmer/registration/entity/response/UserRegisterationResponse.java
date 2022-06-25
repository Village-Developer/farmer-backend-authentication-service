package com.village.farmer.registration.entity.response;

import com.village.farmer.generics.entity.response.GenericsResponse;

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
