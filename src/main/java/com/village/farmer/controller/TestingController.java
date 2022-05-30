package com.village.farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.entity.Users;
import com.village.farmer.jwt.JwtAuth;
import com.village.farmer.model.request.LoginRequest;
import com.village.farmer.repository.UserRepository;

@RestController
@RequestMapping("/test")
public class TestingController {
	
	@Autowired UserRepository userRepo;
	@Autowired JwtAuth jwt;
	
	@GetMapping("/user/list")
    public List<Users> listUser(){
        return userRepo.findAll();
    }
	
	@GetMapping("/msg")
    public String test(){
        return "FCK";
    }
	
	@PostMapping("/jwt")
	@ResponseBody
	public String getToken() throws Exception {
		LoginRequest fix = new LoginRequest();
		fix.setPassword("000000");
		fix.setUsername("ht101010");
		return jwt.ClaimAuth(fix);
	} 
	
	@GetMapping("/valid")
	@ResponseBody
    public String valid(@RequestHeader("Authorization") String Authorization) throws Exception{
		String token = Authorization.substring("Bearer".length()).trim();
		if(jwt.ValidateJWS(token)) {
			return "valid";
		}else {
			return "invalid";
		}
    }
}
