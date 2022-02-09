package com.eshopee.webservice.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eshopee.webservice.exception.OrderNotFound;
import com.eshopee.webservice.exception.ProductNotFound;
import com.eshopee.webservice.exception.RoleNotFound;
import com.eshopee.webservice.exception.UserNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;

	@ExceptionHandler(value = ProductNotFound.class)
	public ResponseEntity<ExceptionResponse> productNotFound(ProductNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = UserNotFound.class)
	public ResponseEntity<ExceptionResponse> userNotFound(UserNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = RoleNotFound.class)
	public ResponseEntity<ExceptionResponse> roleNotFound(RoleNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = OrderNotFound.class)
	public ResponseEntity<ExceptionResponse> OrderNotFound(OrderNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}



}
