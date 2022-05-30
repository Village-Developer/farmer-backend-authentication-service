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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="districts")
@GenericGenerator(name = "idGenerator",strategy = "native")
public class Districts implements Serializable {

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.AUTO) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "district")
	private String district;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Provinces province;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "subdistict_id", referencedColumnName = "id")
	private Collection<Subdistricts> subdistrict_id = new HashSet<Subdistricts>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Provinces getProvince() {
		return province;
	}

	public void setProvince(Provinces province) {
		this.province = province;
	}

	public Collection<Subdistricts> getSubdistrict_id() {
		return subdistrict_id;
	}

	public void setSubdistrict_id(Collection<Subdistricts> subdistrict_id) {
		this.subdistrict_id = subdistrict_id;
	}
	
}
