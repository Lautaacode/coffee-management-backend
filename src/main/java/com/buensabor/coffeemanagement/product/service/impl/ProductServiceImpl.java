package com.buensabor.coffeemanagement.product.service.impl;

import com.buensabor.coffeemanagement.product.entity.Product;
import com.buensabor.coffeemanagement.product.repository.ProductRepository;
import com.buensabor.coffeemanagement.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findActive() {
        return productRepository.findByActiveTrue();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = findById(id);

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());

        return productRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);
        product.setActive(false); // soft delete
        productRepository.save(product);
    }
}