package com.buensabor.coffeemanagement.supply.repository;

import com.buensabor.coffeemanagement.product.entity.Product;
import com.buensabor.coffeemanagement.supply.entity.ProductSupply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSupplyRepository extends JpaRepository<ProductSupply, Long> {
    List<ProductSupply> findByProduct(Product product);
}