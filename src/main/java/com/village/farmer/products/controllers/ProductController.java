package com.village.farmer.products.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.village.farmer.products.entity.Product;
import com.village.farmer.products.repository.ProductRepository;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String productName) {
        try {
            List<Product> products = new ArrayList<Product>();
            if (productName == null)
                productRepository.findAll().forEach(products::add);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/products/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") Long id) {
        Optional<Product> productData = productRepository.findById(id);
        if(productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            Product _product = productRepository
                    .save(new Product(product.getProductName(), product.getDetail(), product.getPrice()));
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/products/{product_id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("product_id") Long id, @RequestBody Product product) {
        Optional<Product> productData = productRepository.findById(id);
        if(productData.isPresent()) {
            Product _product = productData.get();
            _product.setProductName(product.getProductName());
            _product.setDetail(product.getDetail());
            _product.setPrice(product.getPrice());
            return new ResponseEntity(productRepository.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/products/{product_id}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("product_id") Long id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllProduct() {
        try {
            productRepository.deleteAll();
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}