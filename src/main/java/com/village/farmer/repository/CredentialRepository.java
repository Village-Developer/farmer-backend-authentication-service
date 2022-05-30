package com.village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.entity.Credentials;

public interface CredentialRepository extends JpaRepository<Credentials, Integer> {

	String findByUser(String username);
}
