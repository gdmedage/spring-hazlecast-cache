package com.org.cache.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.cache.api.model.user.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
