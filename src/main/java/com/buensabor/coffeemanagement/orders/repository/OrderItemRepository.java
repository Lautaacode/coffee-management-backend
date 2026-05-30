package com.buensabor.coffeemanagement.orders.repository;

import com.buensabor.coffeemanagement.orders.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}