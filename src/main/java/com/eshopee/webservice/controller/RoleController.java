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

import com.eshopee.webservice.Dao.RoleDao;
import com.eshopee.webservice.exception.RoleNotFound;
import com.eshopee.webservice.model.Role;

@RestController
public class RoleController {
	@Autowired
	RoleDao roleDao;

	@GetMapping("/role")
	public Role getRoleById(@RequestParam("name") String name) {
		Role role = roleDao.findByName(name);
		if (role != null) {
			return role;

		}
		throw new RoleNotFound("Role is Not Found With Given Name" + name);

	}

	@GetMapping("/roles/{id}")
	public Role getRoleById(@PathVariable("id") int id) {
		Role role = roleDao.findById(id);
		if (role != null) {
			return role;

		}
		throw new RoleNotFound("Role Not Found with given id +" + id);

	}

	@GetMapping("/roles")
	public List<Role> getRoles() {
		List<Role> list = roleDao.findAll();
		if (list.isEmpty()) {
			throw new RoleNotFound("Role List is Empty,Zero Record Found ");
		}
		return list;

	}

	@PostMapping("/roles")
	public Map<String, String> addRole(@RequestBody Role role) {
		int rowsAffected = roleDao.insert(role);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Role created successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@PutMapping("/role/{id}")
	public Map<String, String> updateRoleById(@PathVariable("id") int id, @RequestBody Role role) {
		int rowsAffected = roleDao.update(role);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "role Update successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;

	}

	@DeleteMapping("/role/{id}")
	public Map<String, String> deleteRoleById(@PathVariable("id") int id) {
		int rowsAffected = roleDao.delete(id);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "role Delete successfully");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

}
