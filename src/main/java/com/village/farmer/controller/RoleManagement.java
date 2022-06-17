package com.village.farmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.model.request.AdminRoleManageRequest;
import com.village.farmer.model.response.GenericsResponse;
import com.village.farmer.service.Permission;
import com.village.farmer.service.RoleManage;

@RestController
@RequestMapping("/manage/role")
public class RoleManagement {

	@Autowired Permission permission;
	@Autowired RoleManage manage; 
	
	@PutMapping("/admin/edit")
	public ResponseEntity<?> edit(@RequestParam("Authentication") String token, AdminRoleManageRequest request) {
		GenericsResponse res = new GenericsResponse();
		try {
			if(!permission.AdminPermission(token)) {
				res.setMsg("Not Allow");
				return ResponseEntity
						.status(HttpStatus.FORBIDDEN)
						.body(res);
			}
			return manage.EditRole(res, request.getUsername(), request.getRole());
		} catch (Exception e) {
			res.setMsg("Role is not Change");
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(res);
		}
	}
	
	@PostMapping("/admin/add")
	public ResponseEntity<?> add(@RequestParam("Authentication") String token, AdminRoleManageRequest request) {
		GenericsResponse res = new GenericsResponse();
		try {
			if(!permission.AdminPermission(token)) {
				res.setMsg("Not Allow");
				return ResponseEntity
						.status(HttpStatus.FORBIDDEN)
						.body(res);
			}
			return manage.AddRole(res, request.getRole());
		} catch (Exception e) {
			res.setMsg("Role is not Change");
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(res);
		}
	}
}
