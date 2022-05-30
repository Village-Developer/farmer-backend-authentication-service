package com.village.farmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.model.request.LoginRequest;
import com.village.farmer.model.response.LoginResponse;

@RestController
@RequestMapping("/auth")
public class Authentication {
	
	@PostMapping("/login")
	public LoginResponse Login(@RequestBody LoginRequest login) throws Exception {
		LoginResponse response = new LoginResponse();
//		try {
//			UsernamePasswordAuthenticationToken authorize = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
//			authen.authenticate(authorize);
//		} catch (Exception e) {
//			response.setCode("500");
//			response.setStatus("Err");
//			response.setMessage("Username or Password not found");
//		}

		return response;
	}
}