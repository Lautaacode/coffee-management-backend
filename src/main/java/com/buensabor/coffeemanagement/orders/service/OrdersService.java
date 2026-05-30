package com.buensabor.coffeemanagement.orders.service;

import com.buensabor.coffeemanagement.orders.entity.OrderStatus;
import com.buensabor.coffeemanagement.orders.entity.Orders;

import java.util.List;

public interface OrdersService {

    Orders create(Orders order);

    Orders findById(Long id);

    List<Orders> findAll();

    Orders updateStatus(Long id, OrderStatus status);
}