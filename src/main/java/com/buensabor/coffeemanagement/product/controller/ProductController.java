package com.buensabor.coffeemanagement.product.controller;

import com.buensabor.coffeemanagement.product.entity.Product;
import com.buensabor.coffeemanagement.product.entity.ProductCategory;
import com.buensabor.coffeemanagement.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/products")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Product> create(
            @RequestBody Product product
    ) {
        return ResponseEntity.ok(
                service.create(product)
        );
    }

    @GetMapping("/products")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Product> findById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @GetMapping("/products/active")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Product>> findActive() {

        return ResponseEntity.ok(
                service.findActive()
        );
    }

    @GetMapping("/category/{category}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Product>>
    findByCategory(
            @PathVariable ProductCategory category
    ) {

        return ResponseEntity.ok(
                service.findByCategory(category)
        );
    }

    @GetMapping("/search")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Product>>
    search(
            @RequestParam String name
    ) {

        return ResponseEntity.ok(
                service.searchByName(name)
        );
    }

    @PatchMapping("/products/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product product
    ) {
        return ResponseEntity.ok(
                service.update(id, product)
        );
    }

    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Product> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}