package com.village.farmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.model.request.AdminRegistrationRequest;
import com.village.farmer.model.request.UserRegisterationRequest;
import com.village.farmer.model.response.GenericsResponse;
import com.village.farmer.model.response.UserRegisterationResponse;
import com.village.farmer.service.Permission;
import com.village.farmer.service.Register;

@RestController
@RequestMapping("/register")
public class Registeration {

	@Autowired Register register;
	@Autowired Permission permission;
	
	@PostMapping("/user")
	public ResponseEntity<UserRegisterationResponse> UserRegister(@RequestBody UserRegisterationRequest form) {
		UserRegisterationResponse res = new UserRegisterationResponse();
		try {
			if(!(form.getRole().getRole().equals("user"))) {
				res.setMsg("Fail: Not Allow for Administration Register");
				res.setUser(form.getCredential().getUser());
				return ResponseEntity
						.status(HttpStatus.FORBIDDEN)
						.body(res);
			}
			register.UserRegisteration(form);
			res.setMsg("Success");
			res.setUser(form.getCredential().getUser());
			res.setRole(form.getRole().getRole());
			return ResponseEntity
					.ok()
					.body(res);
		} catch (Exception e) {
			res.setMsg("Fail: "+e.getMessage());
			res.setUser(form.getCredential().getUser());
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(res);
		}
	}
	
	@PostMapping("/admin")
	public ResponseEntity<?> AdminRegister (@RequestParam("Authentication") String token,@RequestBody AdminRegistrationRequest form) {
		GenericsResponse res = new GenericsResponse();
		try {
			if(!permission.AdminPermission(token)) {
				res.setMsg("No Allow");
				return ResponseEntity
						.status(HttpStatus.FORBIDDEN)
						.body(res);
			}
			return null;
		} catch (Exception e) {
			res.setMsg("Role is not Change");
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(res);
		}
	}
}
