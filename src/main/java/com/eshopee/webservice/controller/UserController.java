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

import com.eshopee.webservice.Dao.UserDao;
import com.eshopee.webservice.exception.UserNotFound;
import com.eshopee.webservice.model.User;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;

	@GetMapping("/user")
	public User getUserById(@RequestParam("name") String name) {
		User user = userDao.findByName(name);
		if (user != null) {
			return user;

		}
		throw new UserNotFound("User is Not Found With Given Name" + name);

	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") int id) {
		User user = userDao.findById(id);
		if (user != null) {
			return user;

		}
		throw new UserNotFound("Product Not Found with given id +" + id);

	}

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> list = userDao.findAll();
		if (list.isEmpty()) {
			throw new UserNotFound("User List is Empty,Zero Record Found ");
		}
		return list;

	}

	@PostMapping("/users")
	public Map<String, String> addUser(@RequestBody User user) {
		int rowsAffected = userDao.insert(user);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "User created successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@PutMapping("/user/{id}")
	public Map<String, String> updateUserById(@PathVariable("id") int id, @RequestBody User user) {
		int rowsAffected = userDao.update(user);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "user Update successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;

	}

	@DeleteMapping("/user/{id}")
	public Map<String, String> deleteUserById(@PathVariable("id") int id) {
		int rowsAffected = userDao.delete(id);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "User Delete successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

}
