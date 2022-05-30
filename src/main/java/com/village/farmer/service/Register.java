package com.village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Users;
import com.village.farmer.model.request.UserRegisterationRequest;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.UserRepository;

@Service
public class Register {
	
	@Autowired CredentialRepository credRepo;
	@Autowired UserRepository userRepo;
	
	public void Registeration(UserRegisterationRequest data) {
		Users userDb = new Users();
		if(ValidateRegister(data.getCredential().getUser(), data.getCredential().getPass())) {
			userDb.setActive(true);
			userDb.setAddr(data.getAddr());
			userDb.setCred(data.getCredential());
			userDb.setPosition_id(data.getJob());
			userDb.setRole_id(data.getRole());
			userDb.setFname(data.getFname());
			userDb.setLname(data.getLname());
			
			userRepo.save(userDb);
		}
	}
	
	public Boolean ValidateRegister(String username, String password) {
		boolean checker = true;
		
		// username
		if (!DuplicateUser(username)) {
			checker = false;
		}
		if (!(username.length()>=4)) {
			checker = false;
		}
		
		//password
		if (!PasswordStrength(password)) {
			checker = false;
		}
		return checker;
	}
	
	public Boolean DuplicateUser(String username) {
		if(credRepo.findByUser(username).equals(null)) {
			return true;
		}else {
			return false;
		}
	}

	public Boolean PasswordStrength(String password) {
		float score = 0;
		int count = 0;
		
		if (password.length()>=8) {
			score++;
		} else {
			score-=2;
		}
		
		if (password.contains("[a-z]")) {
			count++;
		} else {
			count--;
		}
		if (password.contains("[0-9]")) {
			count++;
		} else {
			count--;
		}
		if (password.contains("[A-Z]")) {
			count++;
		} else {
			count--;
		}
		if (password.contains("[^A-Za-z0-9]")) {
			count++;
		} else {
			count--;
		}
		
		// Bonus
		if(count>2) {
			score++;
		}
		
		score = count/2 + 1;
		
		if(score>=3.5) {
			return true;
		} else {
			return false;
		}
	}
}
