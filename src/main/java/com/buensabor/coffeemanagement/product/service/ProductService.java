package com.buensabor.coffeemanagement.product.service;

import com.buensabor.coffeemanagement.product.entity.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    List<Product> findAll();

    List<Product> findActive();

    Product findById(Long id);

    Product update(Long id, Product product);

    void delete(Long id);
}