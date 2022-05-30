package com.village.farmer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="postcodes")
@GenericGenerator(name = "idGenerator",strategy = "native")
public class Postcodes implements Serializable {

	@Id
	@GeneratedValue(generator="idGenerator", strategy=GenerationType.AUTO) 
	@Column(name ="id",nullable = false)
	private Integer id;
	
	@Column(name = "postcode")
	private String postcode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Subdistricts subdistrict;
}
