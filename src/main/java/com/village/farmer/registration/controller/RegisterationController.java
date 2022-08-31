package com.village.farmer.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.registration.entity.request.AdminRegistrationRequest;
import com.village.farmer.registration.entity.request.UserRegisterationRequest;
import com.village.farmer.generics.entity.response.GenericsResponse;
import com.village.farmer.registration.entity.response.UserRegisterationResponse;
import com.village.farmer.authorization.service.Permission;
import com.village.farmer.registration.service.RegisterService;
import com.village.farmer.statics.StaticsParameter;
import com.village.farmer.statics.StatusStatic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/register")
public class RegisterationController {

	@Autowired
	RegisterService register;
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
