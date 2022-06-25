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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subdistricts")
//@GenericGenerator(name = "idGenerator",strategy = "native")
public class Subdistricts {

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.IDENTITY) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "subdistrict")
	private String subdistrict;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Districts district;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "postcode_id", referencedColumnName = "id")
	private Collection<Postcodes> postcode_id = new HashSet<Postcodes>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public Districts getDistrict() {
		return district;
	}

	public void setDistrict(Districts district) {
		this.district = district;
	}

	public Collection<Postcodes> getPostcode_id() {
		return postcode_id;
	}

	public void setPostcode_id(Collection<Postcodes> postcode_id) {
		this.postcode_id = postcode_id;
	}
	
}
