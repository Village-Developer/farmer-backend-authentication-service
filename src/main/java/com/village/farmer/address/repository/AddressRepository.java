package com.village.farmer.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
