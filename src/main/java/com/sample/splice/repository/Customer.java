package com.sample.splice.repository;

public class Customer {

	private Integer id;
	private String name;
	private String email;

	public Customer(int i, String string, String string2) {
		this.id = i;
		this.name = string;
		this.email = string2;
	}

	public Customer() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}
}
