package com.saloa.forward.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue
	@Column(length=20,nullable=false)
	private Long id;
	@Column(name="name",length=20,nullable=false)
	private String name;
	private String addres;
	
	
	public Person(Long id, String name, String addres) {
		super();
		this.id = id;
		this.name = name;
		this.addres = addres;
	}


	public Person() {
		super();
	}


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


	public String getAddres() {
		return addres;
	}


	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	

}
