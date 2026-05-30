package com.buensabor.coffeemanagement.orders.service;

import com.buensabor.coffeemanagement.orders.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    OrderItem create(OrderItem item);

    void delete(Long id);

    List<OrderItem> findByOrder(Long orderId);
}