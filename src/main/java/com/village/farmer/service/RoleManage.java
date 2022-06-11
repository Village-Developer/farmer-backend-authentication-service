package com.village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Credentials;
import com.village.farmer.entity.Roles;
import com.village.farmer.entity.Users;
import com.village.farmer.model.response.GenericsResponse;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.RoleRepository;
import com.village.farmer.repository.UserRepository;

@Service
public class RoleManage {

	@Autowired CredentialRepository credRepo;
	@Autowired UserRepository userRepo;
	@Autowired RoleRepository roleRepo;
	
	public ResponseEntity<?> EditRole(GenericsResponse response, String username, String role) {
		Credentials credential = credRepo.findByUser(username);
		Users user = userRepo.findByCredential(credential);
		user.setRole_id(roleRepo.findByRole(role.toLowerCase()));
		userRepo.save(user);
		response.setMsg("Success");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
	public ResponseEntity<?> AddRole(GenericsResponse response, String role) {
		Roles roleDb = new Roles();
		roleDb.setRole(role);
		roleRepo.save(roleDb);
		response.setMsg("Success");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
}
