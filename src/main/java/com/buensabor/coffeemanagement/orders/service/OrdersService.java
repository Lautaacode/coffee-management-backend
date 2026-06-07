package com.buensabor.coffeemanagement.orders.service;

import com.buensabor.coffeemanagement.orders.dtos.CreateOrderRequest;
import com.buensabor.coffeemanagement.orders.entity.OrderStatus;
import com.buensabor.coffeemanagement.orders.entity.Orders;

import java.util.List;

public interface OrdersService {

    Orders create(Long tableId, Long waiterId);

    Orders findById(Long id);

    List<Orders> findAll();

    List<Orders> findByStatus(OrderStatus status);

    Orders startPreparation(Long orderId);

    Orders ready(Long orderId);

    Orders delivered(Long orderId);

    Orders close(Long orderId);

}