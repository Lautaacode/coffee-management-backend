package com.buensabor.coffeemanagement.orderitem.controller;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;
import com.buensabor.coffeemanagement.orderitem.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {

        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<OrderItem> addItem(

            @RequestParam Long orderId,

            @RequestParam Long productId,

            @RequestParam Integer quantity) {

        return ResponseEntity.ok(service.addItem(orderId, productId, quantity));
    }

    @GetMapping("/order/{orderId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<OrderItem>> findByOrder(@PathVariable Long orderId) {

        return ResponseEntity.ok(service.findByOrder(orderId));
    }

    @PatchMapping("/{itemId}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<OrderItem> updateQuantity(

            @PathVariable Long itemId,

            @RequestParam Integer quantity) {

        return ResponseEntity.ok(service.updateQuantity(itemId, quantity));
    }

    @DeleteMapping("/{itemId}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','MANAGER','WAITER')")
    public ResponseEntity<Void> removeItem(@PathVariable Long itemId) {

        service.removeItem(itemId);

        return ResponseEntity.noContent().build();
    }
}
