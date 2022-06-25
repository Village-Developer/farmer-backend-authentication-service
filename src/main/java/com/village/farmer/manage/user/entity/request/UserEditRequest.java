package com.village.farmer.manage.user.entity.request;

import com.village.farmer.address.entity.Address;

public class UserEditRequest {
    private Address addr;
    private String tel;
    private String email;
	private String fname;
	private String lname;

    public Address getAddr() {
        return this.addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
