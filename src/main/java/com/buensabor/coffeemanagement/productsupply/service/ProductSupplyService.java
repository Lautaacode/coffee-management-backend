package com.buensabor.coffeemanagement.productsupply.service;

import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;

import java.util.List;

public interface ProductSupplyService {

    ProductSupply create(ProductSupply productSupply);

    ProductSupply findById(Long id);

    List<ProductSupply> findAll();

    ProductSupply update(Long id,
                         ProductSupply productSupply);

    void delete(Long id);

    List<ProductSupply> findByProduct(Long productId);

    List<ProductSupply> findBySupply(Long supplyId);

}