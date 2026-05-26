package com.buensabor.coffeemanagement.product.repository;

import com.buensabor.coffeemanagement.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}