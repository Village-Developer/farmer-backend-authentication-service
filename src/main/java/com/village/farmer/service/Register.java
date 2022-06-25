package com.village.farmer.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Users;
import com.village.farmer.model.request.AdminRegistrationRequest;
import com.village.farmer.model.request.UserRegisterationRequest;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.RoleRepository;
import com.village.farmer.repository.UserRepository;
import com.village.farmer.statics.StaticsParameter;
import com.village.farmer.statics.StatusStatic;

@Service
public class Register {
	
	@Autowired CredentialRepository credRepo;
	@Autowired RoleRepository roleRepo;
	@Autowired UserRepository userRepo;
	
	public void UserRegisteration(UserRegisterationRequest data) throws Exception {
		Users userDb = new Users();
		try {
			if(UserExist(data.getCredential().getUser())) {
			throw new Exception(StatusStatic.REG_02);
		}
			if(ValidateRegister(data.getCredential().getUser(), data.getCredential().getPass())) {
				userDb.setActive(true);
				userDb.setAddr(data.getAddr());
	 			userDb.setCred(data.getCredential());
	 			userDb.setPosition_id(data.getJob());
				userDb.setFname(data.getFname());
				userDb.setLname(data.getLname());
				userDb.setRole_id(roleRepo.findByRole(StaticsParameter.ROLE_USER));
				userRepo.save(userDb);
			} else {
				throw new Exception(StatusStatic.REG_01);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	private boolean UserExist(String username) {
		if(credRepo.findByUser(username)==null) {
			return false;
		}
		return true;
	}

	public Boolean ValidateRegister(String username, String password) {
		
		if (username.length()<4) {
			return false;
		}
		
		//password
		if (!PasswordStrength(password)) {
			return false;
		}
		return true;
	}

	public Boolean PasswordStrength(String password) {
		int score = 0;
		if (password.length()>=8) {
			score++;
		} else {
			score-=2;
		}

		if (Matching("[0-9]", password)) {
			score++;
		} else {
			score--;
		}
		if (Matching("[a-z]", password)) {
			score++;
		} else {
			score--;
		}
		if (Matching("[A-Z]", password)) {
			score++;
		} else {
			score--;
		}
		if (Matching("[^A-Za-z0-9]", password)) {
			score++;
		} else {
			score--;
		}
		if(score>=3) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean Matching (String regex, String password) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.find();
	}
	
	public void AdminRegister(AdminRegistrationRequest data) throws Exception {
		if(UserExist(data.getCredential().getUser())) {
			throw new Exception("user exist");
		}
		Users user = new Users();
		user.setActive(true);
		user.setRole_id(data.getRole());
		user.setCred(data.getCredential());
		user.setFname(data.getFname());
		user.setLname(data.getLname());
		userRepo.save(user);
	} 
}
