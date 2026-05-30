package com.buensabor.coffeemanagement.orders.repository;

import com.buensabor.coffeemanagement.orders.entity.OrderStatus;
import com.buensabor.coffeemanagement.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByStatus(OrderStatus status);
}