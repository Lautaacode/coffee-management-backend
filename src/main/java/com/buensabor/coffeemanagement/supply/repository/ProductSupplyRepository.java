package com.buensabor.coffeemanagement.supply.repository;

import com.buensabor.coffeemanagement.supply.entity.ProductSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSupplyRepository extends JpaRepository<ProductSupply, Long> {
    
    List<ProductSupply> findByProduct_Id(Long productId);
}