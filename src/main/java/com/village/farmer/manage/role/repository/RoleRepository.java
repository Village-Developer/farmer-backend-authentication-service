package com.village.farmer.manage.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.manage.role.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

    Roles findByRole (String role);
}
