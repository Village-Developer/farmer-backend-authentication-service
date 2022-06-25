package com.village.farmer.manage.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmer.authentication.entity.Credentials;
import com.village.farmer.manage.role.entity.Roles;
import com.village.farmer.manage.user.entity.Users;
import com.village.farmer.generics.entity.response.GenericsResponse;
import com.village.farmer.authentication.repository.CredentialRepository;
import com.village.farmer.manage.role.repository.RoleRepository;
import com.village.farmer.manage.user.repository.UserRepository;
import com.village.farmer.statics.StatusStatic;

@Service
public class RoleManage {

	@Autowired CredentialRepository credRepo;
	@Autowired UserRepository userRepo;
	@Autowired RoleRepository roleRepo;
	
	public void EditRole(GenericsResponse response, String username, String role) throws Exception {
		try {
			Credentials credential = credRepo.findByUser(username);
			Users user = userRepo.findByCred(credential);
			user.setRole_id(roleRepo.findByRole(role.toLowerCase()));
			userRepo.save(user);
			response.setMsg(StatusStatic.MANAGE_ROLE_01);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void AddRole(GenericsResponse response, String role) throws Exception {
		try {
			Roles roleDb = new Roles();
			roleDb.setRole(role);
			roleRepo.save(roleDb);
			response.setMsg(StatusStatic.MANAGE_ROLE_02);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void DelRole(GenericsResponse response, String role) throws Exception {
		try {
			Roles roleDb = roleRepo.findByRole(role);
			roleRepo.delete(roleDb);
			response.setMsg(StatusStatic.MANAGE_ROLE_03);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
