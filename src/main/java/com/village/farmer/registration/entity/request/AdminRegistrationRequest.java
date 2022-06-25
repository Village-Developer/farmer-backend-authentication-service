package com.village.farmer.registration.entity.request;

import com.village.farmer.authentication.entity.Credentials;
import com.village.farmer.manage.role.entity.Roles;

public class AdminRegistrationRequest {
	private Credentials credential;
	private Roles role;
	private Boolean isactive;
	private String fname;
	private String lname;
	
	public Credentials getCredential() {
		return credential;
	}
	public void setCredential(Credentials credential) {
		this.credential = credential;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
