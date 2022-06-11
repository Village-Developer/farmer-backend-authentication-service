package com.village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

    Roles findByRole (String role);
}
