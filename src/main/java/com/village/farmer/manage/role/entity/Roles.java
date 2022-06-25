package com.village.farmer.manage.role.entity;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.village.farmer.manage.user.entity.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
//@GenericGenerator(name = "idGenerator",strategy = "native")
public class Roles {

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.IDENTITY) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "role")
	private String role;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role_id")
	private Collection<Users> users = new HashSet<Users>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Users> getUsers() {
		return users;
	}

	public void setUsers(Collection<Users> users) {
		this.users = users;
	}

}
