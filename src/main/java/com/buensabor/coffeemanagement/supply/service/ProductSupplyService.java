package com.buensabor.coffeemanagement.supply.service;

import com.buensabor.coffeemanagement.supply.entity.ProductSupply;

import java.util.List;

public interface ProductSupplyService {

    ProductSupply create(ProductSupply productSupply);

    List<ProductSupply> findByProduct(Long productId);
}