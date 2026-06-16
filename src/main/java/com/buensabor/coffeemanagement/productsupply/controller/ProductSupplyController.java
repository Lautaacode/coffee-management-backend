package com.buensabor.coffeemanagement.productsupply.controller;

import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import com.buensabor.coffeemanagement.productsupply.service.ProductSupplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-supplies")
public class ProductSupplyController {

    private final ProductSupplyService service;

    public ProductSupplyController(
            ProductSupplyService service) {

        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<ProductSupply> create(
            @RequestBody ProductSupply productSupply) {

        return ResponseEntity.ok(
                service.create(productSupply)
        );
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ProductSupply>> findAll() {

        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ProductSupply> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<ProductSupply> update(
            @PathVariable Long id,
            @RequestBody ProductSupply productSupply) {

        return ResponseEntity.ok(
                service.update(id, productSupply)
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{productId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ProductSupply>>
    findByProduct(
            @PathVariable Long productId) {

        return ResponseEntity.ok(
                service.findByProduct(productId)
        );
    }

    @GetMapping("/supply/{supplyId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ProductSupply>>
    findBySupply(
            @PathVariable Long supplyId) {

        return ResponseEntity.ok(
                service.findBySupply(supplyId)
        );
    }
}