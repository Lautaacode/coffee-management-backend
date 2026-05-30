package com.buensabor.coffeemanagement.orders.service.impl;

import com.buensabor.coffeemanagement.orders.entity.OrderStatus;
import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.orders.repository.OrdersRepository;
import com.buensabor.coffeemanagement.orders.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository repository;

    public OrdersServiceImpl(OrdersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Orders create(Orders order) {
        order.setStatus(OrderStatus.CREATED);
        return repository.save(order);
    }

    @Override
    public Orders findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Orders> findAll() {
        return repository.findAll();
    }

    @Override
    public Orders updateStatus(Long id, OrderStatus status) {
        Orders orders = findById(id);
        orders.setStatus(status);
        return repository.save(orders);
    }
}