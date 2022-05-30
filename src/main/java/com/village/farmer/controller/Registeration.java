package com.village.farmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.model.request.UserRegisterationRequest;
import com.village.farmer.model.response.UserRegisterationResponse;
import com.village.farmer.service.Register;

@RestController
@RequestMapping("/register")
public class Registeration {

	@Autowired Register register;
	
	@PostMapping("/user")
	public UserRegisterationResponse UserRegister(@RequestBody UserRegisterationRequest form) {
		UserRegisterationResponse res = new UserRegisterationResponse();
		try {
			register.Registeration(form);
			res.setStatus("200");
			res.setMsg("Success");
			res.setUser(form.getCredential().getUser());
			res.setRole(form.getRole().getRole());
		} catch (Exception e) {
			res.setStatus("500");
			res.setMsg("Fail: "+e.getMessage());
			res.setUser(form.getCredential().getUser());
		}
		return res;
	}
}
