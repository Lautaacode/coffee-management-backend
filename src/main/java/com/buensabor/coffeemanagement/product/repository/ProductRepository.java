package com.buensabor.coffeemanagement.product.repository;

import com.buensabor.coffeemanagement.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActiveTrue();

}