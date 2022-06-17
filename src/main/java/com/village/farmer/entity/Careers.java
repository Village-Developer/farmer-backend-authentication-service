package com.village.farmer.entity;

import java.io.Serializable;
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

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="careers")
@GenericGenerator(name = "idGenerator",strategy = "native")
public class Careers implements Serializable {

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.AUTO) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "career")
	private String career;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position_id")
	private Collection<Users> users = new HashSet<Users>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public Collection<Users> getUsers() {
		return users;
	}

	public void setUsers(Collection<Users> users) {
		this.users = users;
	}

}
