package com.eshopee.webservice.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshopee.webservice.Dao.OrderDao;
import com.eshopee.webservice.exception.OrderNotFound;
import com.eshopee.webservice.model.Order;
@RestController
public class OrderController {
	@Autowired
	OrderDao orderDao;
	@GetMapping("/order")
	public Order getOrderByName(@RequestParam("name")String name) {
		Order order = orderDao.findByName(name);
		if(order !=null) {
			return order;
			
		}
		throw new OrderNotFound("Order is Not Found With Given Name"+name);
		
	}
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable("id")int id) {
		Order order = orderDao.findById(id);
		if(order !=null) {
			return order;
			
		}
		throw new OrderNotFound("Order Not Found with given id +"+id);
		
		
	}
	@GetMapping("/orders")
	public List<Order>getOrder(){
		List<Order>list=orderDao.findAll();
		if(list.isEmpty()) {
			throw new OrderNotFound("Order List is Empty,Zero Record Found ");
		}
		return list;
		
	}
	@PostMapping("/orders")
	public Map<String, String> addOrder(@RequestBody Order order) {
		int rowsAffected = orderDao.insert(order);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Order Added successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@PutMapping ("/order/{id}")
	public Map<String, String>updateOrdertById(@PathVariable("id")int id, @RequestBody Order order){
		int rowsAffected = orderDao.update(order);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "order Update successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
		
		
	}
	@DeleteMapping("/order/{id}")
	public Map<String, String> deleteOrderById(@PathVariable("id")int id){
		 int rowsAffected = orderDao.delete(id);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Order Delete successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}
	
}
	


