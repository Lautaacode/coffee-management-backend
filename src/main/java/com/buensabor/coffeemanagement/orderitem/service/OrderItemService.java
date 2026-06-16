package com.buensabor.coffeemanagement.orderitem.service;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    OrderItem addItem(Long orderId, Long productId, Integer quantity);

    List<OrderItem> findByOrder(Long orderId);

    OrderItem updateQuantity(Long itemId, Integer quantity);

    void removeItem(Long itemId);

}