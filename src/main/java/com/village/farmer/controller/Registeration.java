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
import com.village.farmer.statics.StaticsParameter;
import com.village.farmer.statics.StatusStatic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/register")
public class Registeration {

	@Autowired Register register;
	@Autowired Permission permission;
	
	@PostMapping("/user")
	public ResponseEntity<UserRegisterationResponse> UserRegister(@RequestBody UserRegisterationRequest form) {
		UserRegisterationResponse res = new UserRegisterationResponse();
		try {
			register.UserRegisteration(form);
			res.setMsg(StatusStatic.REG_03);
			res.setUser(form.getCredential().getUser());
			res.setRole(StaticsParameter.ROLE_USER);
		} catch (Exception e) {
			res.setMsg(e.getMessage());
			res.setUser(form.getCredential().getUser());
		}
		return ResponseEntity
				.status(StatusStatic.Status(res.getMsg()))
				.body(res);
	}
	
	@PostMapping("/admin")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"), summary = "Unavailable now")
	public ResponseEntity<?> AdminRegister (@RequestParam("Authentication") String token,@RequestBody AdminRegistrationRequest form) {
		GenericsResponse res = new GenericsResponse();
		try {
			if(!permission.AdminPermission(token)) {
				throw new Exception(StatusStatic.PERMISSION);
			}
			throw new Exception("Unavailable");
		} catch (Exception e) {
			res.setMsg(e.getMessage());
		}
		return ResponseEntity
				.status(StatusStatic.Status(res.getMsg()))
				.body(res);
	}
}
