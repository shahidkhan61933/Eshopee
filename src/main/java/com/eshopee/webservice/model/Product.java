package com.eshopee.webservice.model;

import java.util.Date;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private Date createdAt;

	public Product(int id, String name, String description, double price, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
	}

	public Product() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
