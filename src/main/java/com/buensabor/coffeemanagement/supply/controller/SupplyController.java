package com.buensabor.coffeemanagement.supply.controller;

import com.buensabor.coffeemanagement.supply.entity.Supply;
import com.buensabor.coffeemanagement.supply.service.SupplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplies")
public class SupplyController {

    private final SupplyService service;

    public SupplyController(SupplyService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Supply> create(
            @RequestBody Supply supply
    ) {

        return ResponseEntity.ok(
                service.create(supply)
        );
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Supply>> findAll() {

        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Supply> findById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Supply> update(
            @PathVariable Long id,
            @RequestBody Supply supply
    ) {

        return ResponseEntity.ok(
                service.update(id, supply)
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/add-stock")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Supply> addStock(
            @PathVariable Long id,
            @RequestParam Integer quantity
    ) {

        return ResponseEntity.ok(
                service.addStock(id, quantity)
        );
    }

    @PatchMapping("/{id}/remove-stock")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Supply> removeStock(
            @PathVariable Long id,
            @RequestParam Integer quantity
    ) {

        return ResponseEntity.ok(
                service.removeStock(id, quantity)
        );
    }
}