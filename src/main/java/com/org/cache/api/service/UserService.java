package com.org.cache.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.org.cache.api.dao.UserRepository;
import com.org.cache.api.model.user.Users;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Cacheable(cacheNames = { "userCache" })
	public List<Users> getUsers() {
		System.out.println("Hit DB 1st time in getUsers()");
		return repository.findAll();
	}

	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public Users getUser(int id) {
		System.out.println("Hit DB 1st time in getUser()");
		return repository.findById(id).orElse(null);
	}

	@CacheEvict(value = "userCache")
	public String delete(int id) {
		repository.deleteById(id);
		return "User deleted with id " + id;
	}

	public Users addUser(Users user) {
		if(user!=null) {
			return repository.save(user);
		}
		return null;
	}

}
