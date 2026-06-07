package com.buensabor.coffeemanagement.productsupply.repository;


import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSupplyRepository
        extends JpaRepository<ProductSupply, Long> {

    List<ProductSupply> findByProductId(Long productId);

    List<ProductSupply> findBySupplyId(Long supplyId);

    boolean existsByProductIdAndSupplyId(
            Long productId,
            Long supplyId
    );
}