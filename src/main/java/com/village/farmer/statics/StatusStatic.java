package com.village.farmer.statics;

import org.springframework.http.HttpStatus;

public class StatusStatic {

	// authentication reason
	public static final String AUTH_01 = "Invalid Username";
	public static final String AUTH_02 = "Invalid Password";
	public static final String AUTH_03 = "Authentication fail";
	public static final String AUTH_04 = "Login Successful";
	
	// registration reason
	public static final String REG_01 = "Password is Weak";
	public static final String REG_02 = "User Already Exists";
	public static final String REG_03 = "User Created";
	
	// management reason
	public static final String MANAGE_ROLE_01 = "Edit Successful";
	public static final String MANAGE_ROLE_02 = "Add Successful";
	public static final String MANAGE_ROLE_03 = "Delete Successful";
	public static final String MANAGE_USER_01 = "Get Successful";
	public static final String MANAGE_USER_02 = "Edit Successful";
	
	// permission reason
	public static final String PERMISSION = "User Forbidden Access";

	
	public static HttpStatus Status(String err) {

		// authentication
		if(err.equals(AUTH_01)) {
			return HttpStatus.UNAUTHORIZED;
		} else if (err.equals(AUTH_02)) {
			return HttpStatus.UNAUTHORIZED;
		} else if (err.equals(AUTH_03)) {
			return HttpStatus.CONFLICT;
		} else if (err.equals(AUTH_04)) {
			return HttpStatus.OK;
		} 
		
		// registration
		else if (err.equals(REG_01)) {
			return HttpStatus.BAD_REQUEST;
		} else if (err.equals(REG_02)) {
			return HttpStatus.BAD_REQUEST;
		} else if (err.equals(REG_03)) {
			return HttpStatus.CREATED;
		}
		
		// management
		else if (err.equals(MANAGE_ROLE_01)) {
			return HttpStatus.OK;
		} else if (err.equals(MANAGE_ROLE_02)) {
			return HttpStatus.CREATED;
		} else if (err.equals(MANAGE_ROLE_03)) {
			return HttpStatus.NO_CONTENT;
		} else if (err.equals(MANAGE_USER_01)) {
			return HttpStatus.OK;
		} else if (err.equals(MANAGE_USER_02)) {
			return HttpStatus.OK;
		}
		
		// permission
		else if (err.equals(PERMISSION)) {
			return HttpStatus.FORBIDDEN;
		}
		
		// default reason
		else {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
	
}
