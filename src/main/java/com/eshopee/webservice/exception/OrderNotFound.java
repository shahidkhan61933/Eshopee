package com.eshopee.webservice.exception;

public class OrderNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public OrderNotFound(String message) {
		super(message);
	}

}