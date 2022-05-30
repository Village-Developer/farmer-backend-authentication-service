package com.village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
