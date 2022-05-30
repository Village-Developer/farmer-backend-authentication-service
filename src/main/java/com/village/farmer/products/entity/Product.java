package com.village.farmer.products.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id",unique = true, nullable = true)
    private Long id;

    @Column(name="product_name")
    private String productName;

    @Column(name="detail")
    private String detail;

    @Column(name="price")
    private int price;

    public Product() {

    }

    public Product(String productName, String detail, int price) {
        this.productName = productName;
        this.detail = detail;
        this.price = price;
    }
}