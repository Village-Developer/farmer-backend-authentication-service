package com.village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Credentials;
import com.village.farmer.entity.Users;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.UserRepository;

@Service
public class Permission {

	@Autowired CredentialRepository credRepo;
	@Autowired UserRepository userRepo;
	
	public Boolean AdminPermission(String username) {
		Credentials credential = credRepo.findByUser(username);
		Users user = userRepo.findByCredential(credential);
		
		if(user.getRole_id()!=null) {
			if(user.getRole_id().getRole().equals("super admin")&&user.getActive()) {
				return true;
			}
		}
		return false;
	}
}
