package com.village.farmer.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.village.farmer.products.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {

}