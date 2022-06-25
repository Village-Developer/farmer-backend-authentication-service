package com.village.farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.entity.Users;
import com.village.farmer.repository.UserRepository;

@RestController
@RequestMapping("/q")
public class Question {

	@Autowired UserRepository userRepository;
	
	@GetMapping("/get")
	public List<Users> ask_get() {
		return userRepository.findByRole("user");
	}
}
