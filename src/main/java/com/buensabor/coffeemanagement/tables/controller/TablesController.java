package com.buensabor.coffeemanagement.tables.controller;

import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.buensabor.coffeemanagement.tables.service.TablesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TablesController {

    private final TablesService service;

    public TablesController(TablesService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Tables> create(
            @RequestBody Tables table
    ) {

        return ResponseEntity.ok(
                service.create(table)
        );
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Tables>> findAll() {

        return ResponseEntity.ok(
                service.findAll()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Tables> findById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.findById(id)
        );
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER')")
    public ResponseEntity<Tables> update(
            @PathVariable Long id,
            @RequestBody Tables table
    ) {

        return ResponseEntity.ok(
                service.update(id, table)
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

    @PatchMapping("/{id}/open")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<Tables> openTable(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.openTable(id)
        );
    }

    @PatchMapping("/{id}/close")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<Tables> closeTable(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.closeTable(id)
        );
    }

    @GetMapping("/{id}/total")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER','CASHIER')")
    public ResponseEntity<Double> calculateTotal(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.calculateTotal(id)
        );
    }

    @GetMapping("/{id}/orders")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER','COOK')")
    public ResponseEntity<List<Orders>> getOrders(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.getOrders(id)
        );
    }
}