package com.village.farmer.career.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.farmer.career.entity.Careers;

public interface CareerRepository extends JpaRepository<Careers, Integer> {

}
