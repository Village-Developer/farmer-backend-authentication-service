package com.village.farmer.address.entity;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="provinces")
//@GenericGenerator(name = "idGenerator",strategy = "native")
public class Provinces {

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.IDENTITY) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "province")
	private String province;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Collection<Address> address = new HashSet<Address>();
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "distict_id", referencedColumnName = "id")
	private Collection<Districts> distict_id = new HashSet<Districts>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}

	public Collection<Districts> getDistict_id() {
		return distict_id;
	}

	public void setDistict_id(Collection<Districts> distict_id) {
		this.distict_id = distict_id;
	}

}
