package com.village.farmer.authentication.entity.response;

import com.village.farmer.generics.entity.response.GenericsResponse;

public class LoginResponse extends GenericsResponse {
	private String accToken;

	public String getAccToken() {
		return accToken;
	}

	public void setAccToken(String accToken) {
		this.accToken = accToken;
	}
	
	
}
