package com.village.farmer.manage.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.manage.role.entity.request.AdminRoleManageRequest;
import com.village.farmer.manage.role.entity.request.AdminRoleManagementEditRequest;
import com.village.farmer.generics.entity.response.GenericsResponse;
import com.village.farmer.authorization.service.Permission;
import com.village.farmer.manage.role.service.RoleManageService;
import com.village.farmer.statics.StatusStatic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/manage/role")
public class RoleManagementController {

	@Autowired Permission permission;
	@Autowired
	RoleManageService manage;
	
	@PutMapping("/admin/edit")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> edit(@RequestHeader("Authorization") String token, @RequestBody AdminRoleManagementEditRequest request) {
		GenericsResponse res = new GenericsResponse();
		try {
			if(!permission.AdminPermission(token)) {
				throw new Exception(StatusStatic.PERMISSION);
			}
			manage.EditRole(res, request.getUsername(), request.getRole());
			res.setMsg(StatusStatic.MANAGE_ROLE_01);
		} catch (Exception e) {
			res.setMsg(e.getMessage());
		}
		return ResponseEntity
				.status(StatusStatic.Status(res.getMsg()))
				.body(res);
	}
	
	@PostMapping("/admin/add")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> add(@RequestHeader("Authorization") String token, @RequestBody AdminRoleManageRequest request) {
		GenericsResponse res = new GenericsResponse();
		token = token.split(" ")[1];
		try {
			if(!permission.AdminPermission(token)) {
				throw new Exception(StatusStatic.PERMISSION);
			}
			manage.AddRole(res, request.getRole());
			res.setMsg(StatusStatic.MANAGE_ROLE_02);
		} catch (Exception e) {
			res.setMsg(e.getMessage());
		}
		return ResponseEntity
				.status(StatusStatic.Status(res.getMsg()))
				.body(res);
	}
	
	@DeleteMapping("/admin/delete")
	@Operation(security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> delete(@RequestHeader("Authorization") String token, @RequestBody AdminRoleManageRequest request) {
		GenericsResponse res = new GenericsResponse();
		token = token.split(" ")[1];
		try {
			if(!permission.AdminPermission(token)) {
				throw new Exception(StatusStatic.PERMISSION);
			}
			manage.DelRole(res, request.getRole());
			res.setMsg(StatusStatic.MANAGE_ROLE_03);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMsg(e.getMessage());
		}
		return ResponseEntity
				.status(StatusStatic.Status(res.getMsg()))
				.body(res);
	}
}
