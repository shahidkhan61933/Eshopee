package com.eshopee.webservice.model;

import java.util.Date;

public class Order {

	private int id;
	private String ordername;
	private String adress;
	private Date createdAt;

	public Order(int id, String ordername, String adress, Date createdAt) {
		super();
		this.id = id;
		this.ordername = ordername;
		this.adress = adress;
		this.createdAt = createdAt;
	}

	public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
