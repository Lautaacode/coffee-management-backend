package com.buensabor.coffeemanagement.product.service;

import com.buensabor.coffeemanagement.product.entity.Product;
import com.buensabor.coffeemanagement.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product toggleProductActive(Long id, boolean active) {
        Product product = getProductById(id);
        product.setActive(active);
        return productRepository.save(product);
    }
}