package com.eazybytes.eazyschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Technology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String technologyName;

	public Long getId() {
		return id;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}


}
