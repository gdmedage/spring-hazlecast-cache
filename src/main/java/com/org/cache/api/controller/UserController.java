package com.org.cache.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.cache.api.model.user.Users;
import com.org.cache.api.service.UserService;

@RestController
@RequestMapping("/cache-api")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/addUser/")
	public Users addUser(@RequestBody Users user) {
		return service.addUser(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/getUserById/{id}")
	public Users getUser(@PathVariable int id) {
		return service.getUser(id);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.delete(id);
	}

}
