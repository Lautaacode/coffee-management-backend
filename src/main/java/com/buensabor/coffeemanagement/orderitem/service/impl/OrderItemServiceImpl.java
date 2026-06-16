package com.buensabor.coffeemanagement.orderitem.service.impl;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;
import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.orderitem.repository.OrderItemRepository;
import com.buensabor.coffeemanagement.orders.repository.OrdersRepository;
import com.buensabor.coffeemanagement.orderitem.service.OrderItemService;
import com.buensabor.coffeemanagement.product.entity.Product;
import com.buensabor.coffeemanagement.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;

    private final OrdersRepository ordersRepository;

    private final ProductRepository productRepository;

    public OrderItemServiceImpl(OrderItemRepository repository, OrdersRepository ordersRepository, ProductRepository productRepository) {

        this.repository = repository;
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderItem addItem(Long orderId, Long productId, Integer quantity) {

        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        }

        Orders order = ordersRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        if (!product.isActive()) {
            throw new RuntimeException("Product inactive");
        }

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        OrderItem item = new OrderItem();

        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setUnitPrice(product.getPrice());

        return repository.save(item);
    }

    @Override
    public List<OrderItem> findByOrder(Long orderId) {

        return repository.findByOrderId(orderId);
    }

    @Override
    public OrderItem updateQuantity(Long itemId, Integer quantity) {

        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than zero");
        }

        OrderItem item = repository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        item.setQuantity(quantity);

        return repository.save(item);
    }

    @Override
    public void removeItem(Long itemId) {

        repository.deleteById(itemId);
    }
}