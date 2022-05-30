package com.village.farmer.model.request;

import com.village.farmer.entity.Address;
import com.village.farmer.entity.Careers;
import com.village.farmer.entity.Credentials;
import com.village.farmer.entity.Roles;

public class UserRegisterationRequest {

	private Credentials credential;
	private Address addr;
	private Careers job;
	private Roles role;
	private String fname;
	private String lname;
	private Boolean isactive;
	
	public Credentials getCredential() {
		return credential;
	}
	public void setCredential(Credentials credential) {
		this.credential = credential;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public Careers getJob() {
		return job;
	}
	public void setJob(Careers job) {
		this.job = job;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
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
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	
}
