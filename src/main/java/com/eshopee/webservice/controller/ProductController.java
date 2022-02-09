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

import com.eshopee.webservice.Dao.ProductDao;
import com.eshopee.webservice.exception.ProductNotFound;
import com.eshopee.webservice.model.Product;
@RestController
public class ProductController {
	@Autowired
	ProductDao productDao;
	@GetMapping("/product")
	public Product getProductById(@RequestParam("name")String name) {
		Product product = productDao.findByName(name);
		if(product !=null) {
			return product;
			
		}
		throw new ProductNotFound("Product is Not Found With Given Name"+name);
		
	}
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id")int id) {
		Product product = productDao.findById(id);
		if(product !=null) {
			return product;
			
		}
		throw new ProductNotFound("Product Not Found with given id +"+id);
		
		
	}
	@GetMapping("/products")
	public List<Product>getProducts(){
		List<Product>list=productDao.findAll();
		if(list.isEmpty()) {
			throw new ProductNotFound("Product List is Empty,Zero Record Found ");
		}
		return list;
		
	}
	@PostMapping("/products")
	public Map<String, String> addProduct(@RequestBody Product product) {
		int rowsAffected = productDao.insert(product);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Product created successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@PutMapping ("/products/{id}")
	public Map<String, String>updateProductById(@PathVariable("id")int id, @RequestBody Product product){
		int rowsAffected = productDao.update(product);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Product Update successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
		
		
	}
	@DeleteMapping("/product/{id}")
	public Map<String, String> deleteProductById(@PathVariable("id")int id){
		 int rowsAffected = productDao.delete(id);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Product Delete successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}
	
}
	


