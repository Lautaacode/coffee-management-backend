package com.buensabor.coffeemanagement.supply.service.impl;

import com.buensabor.coffeemanagement.product.entity.Product;
import com.buensabor.coffeemanagement.product.repository.ProductRepository;
import com.buensabor.coffeemanagement.supply.entity.ProductSupply;
import com.buensabor.coffeemanagement.supply.repository.ProductSupplyRepository;
import com.buensabor.coffeemanagement.supply.service.ProductSupplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSupplyServiceImpl implements ProductSupplyService {

    private final ProductSupplyRepository repository;
    private final ProductRepository productRepository;

    public ProductSupplyServiceImpl(ProductSupplyRepository repository,
                                    ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductSupply create(ProductSupply productSupply) {
        return repository.save(productSupply);
    }

    @Override
    public List<ProductSupply> findByProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return repository.findByProduct(product);
    }
}