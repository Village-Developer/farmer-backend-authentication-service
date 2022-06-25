package com.village.farmer.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.authentication.entity.Credentials;

public interface CredentialRepository extends JpaRepository<Credentials, Integer> {

	Credentials findByUser(String username);
}
