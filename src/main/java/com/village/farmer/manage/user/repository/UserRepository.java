package com.village.farmer.manage.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.village.farmer.authentication.entity.Credentials;
import com.village.farmer.manage.user.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
    Users findByCred (Credentials cred);
    
    @Query("select u from Users u, Roles r where u.role_id = r.id And r.role = :r")
    List<Users> findByRole (@Param("r") String name);
}
