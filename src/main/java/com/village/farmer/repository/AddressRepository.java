package com.village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
