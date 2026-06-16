package com.buensabor.coffeemanagement.product.service;

import com.buensabor.coffeemanagement.product.entity.Product;
<<<<<<< HEAD
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
=======
import com.buensabor.coffeemanagement.product.entity.ProductCategory;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    List<Product> findAll();

    List<Product> findActive();

    List<Product> findByCategory(ProductCategory category);

    List<Product> searchByName(String name);

    Product findById(Long id);

    Product update(Long id, Product product);

    void delete(Long id);
>>>>>>> sprint3
}