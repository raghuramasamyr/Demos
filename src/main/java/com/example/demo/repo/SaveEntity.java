package com.example.demo.repo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SaveEntity")
public class SaveEntity{

	@Id
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private String company;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumn() { 
		return company;
	}
	public void setColumn(String column) {
		this.company = column;
	}
	
	
	
	
	
}
