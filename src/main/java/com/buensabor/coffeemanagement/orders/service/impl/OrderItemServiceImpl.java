package com.buensabor.coffeemanagement.orders.service.impl;

import com.buensabor.coffeemanagement.orders.entity.OrderItem;
import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.orders.repository.OrderItemRepository;
import com.buensabor.coffeemanagement.orders.repository.OrdersRepository;
import com.buensabor.coffeemanagement.orders.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;
    private final OrdersRepository orderRepository;

    public OrderItemServiceImpl(OrderItemRepository repository,
                                OrdersRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderItem create(OrderItem item) {
        return repository.save(item);
    }

    @Override
    public void delete(Long id) {
        OrderItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        repository.delete(item);
    }

    @Override
    public List<OrderItem> findByOrder(Long orderId) {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return orders.getItems();
    }
}