package com.village.farmer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="credentials")
@GenericGenerator(name = "idGenerator",strategy = "native")
public class Credentials implements Serializable{

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.AUTO) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "pass")
	private String pass;
	
	@OneToOne(mappedBy = "cred")
	private Users users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
}

