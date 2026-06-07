package com.buensabor.coffeemanagement.productsupply.service.impl;

import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import com.buensabor.coffeemanagement.productsupply.repository.ProductSupplyRepository;
import com.buensabor.coffeemanagement.productsupply.service.ProductSupplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSupplyServiceImpl implements ProductSupplyService {

    private final ProductSupplyRepository repository;

    public ProductSupplyServiceImpl(
            ProductSupplyRepository repository) {

        this.repository = repository;
    }

    @Override
    public ProductSupply create(ProductSupply productSupply) {

        Long productId =
                productSupply.getProduct().getId();

        Long supplyId =
                productSupply.getSupply().getId();

        if (repository.existsByProductIdAndSupplyId(
                productId,
                supplyId
        )) {

            throw new RuntimeException(
                    "This supply is already associated with the product"
            );
        }

        return repository.save(productSupply);
    }

    @Override
    public ProductSupply findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Relation not found"));
    }

    @Override
    public List<ProductSupply> findAll() {

        return repository.findAll();
    }

    @Override
    public ProductSupply update(
            Long id,
            ProductSupply productSupply) {

        ProductSupply existing = findById(id);

        existing.setProduct(
                productSupply.getProduct());

        existing.setSupply(
                productSupply.getSupply());

        existing.setQuantity(
                productSupply.getQuantity());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {

        repository.delete(
                findById(id)
        );
    }

    @Override
    public List<ProductSupply> findByProduct(
            Long productId) {

        return repository.findByProductId(productId);
    }

    @Override
    public List<ProductSupply> findBySupply(
            Long supplyId) {

        return repository.findBySupplyId(supplyId);
    }
}