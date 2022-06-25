package com.village.farmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.model.request.LoginRequest;
import com.village.farmer.model.response.LoginResponse;
import com.village.farmer.service.JwsAccessToken;
import com.village.farmer.statics.StatusStatic;

@RestController
@RequestMapping("/auth")
public class Authentication {
	
	@Autowired JwsAccessToken jwt;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> Login(@RequestBody LoginRequest login) throws Exception {
		LoginResponse response = new LoginResponse();
		try {
			String token =  jwt.ClaimAuth(login);
			response.setMsg(StatusStatic.AUTH_04);
			response.setAccToken(token);
		} catch (Exception e) {
			response.setMsg(e.getMessage());
		}
		return ResponseEntity
				.status(StatusStatic.Status(response.getMsg()))
				.body(response);
	}
	
//	@PostMapping("/verify")
//	public Boolean Validate(@RequestHeader("Authorization") String token) throws Exception {
//		return jwt.ValidateJWS(token);
//	}
}