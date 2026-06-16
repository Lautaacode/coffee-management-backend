package com.buensabor.coffeemanagement.orders.controller;

import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.orders.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService service;

    public OrdersController(OrdersService service) {

        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<Orders> create(

            @RequestParam Long tableId,

            @RequestParam Long waiterId) {

        return ResponseEntity.ok(service.create(tableId, waiterId));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Orders>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Orders> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @PatchMapping("/{id}/start")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','COOK')")
    public ResponseEntity<Orders> startPreparation(@PathVariable Long id) {

        return ResponseEntity.ok(service.startPreparation(id));
    }

    @PatchMapping("/{id}/ready")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','COOK')")
    public ResponseEntity<Orders> ready(@PathVariable Long id) {

        return ResponseEntity.ok(service.ready(id));
    }

    @PatchMapping("/{id}/delivered")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<Orders> delivered(@PathVariable Long id) {

        return ResponseEntity.ok(service.delivered(id));
    }

    @PatchMapping("/{id}/close")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<Orders> close(@PathVariable Long id) {

        return ResponseEntity.ok(service.close(id));
    }
}