package com.eshopee.webservice.model;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String phone;
	private String email;
	private Date createdAt;

	public User(int id, String name, String phone, String email, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.createdAt = createdAt;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
