package com.buensabor.coffeemanagement.product.repository;

import com.buensabor.coffeemanagement.product.entity.Product;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
=======
import com.buensabor.coffeemanagement.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {

    List<Product> findByActiveTrue();

    List<Product> findByCategory(
            ProductCategory category
    );

    List<Product> findByNameContainingIgnoreCase(
            String name
    );
>>>>>>> sprint3
}