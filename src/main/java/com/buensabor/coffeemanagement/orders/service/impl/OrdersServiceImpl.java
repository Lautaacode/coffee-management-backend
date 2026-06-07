package com.buensabor.coffeemanagement.orders.service.impl;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;
import com.buensabor.coffeemanagement.orders.entity.OrderStatus;
import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.orders.repository.OrdersRepository;
import com.buensabor.coffeemanagement.orders.service.OrdersService;
import com.buensabor.coffeemanagement.product.entity.Product;
import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import com.buensabor.coffeemanagement.productsupply.repository.ProductSupplyRepository;
import com.buensabor.coffeemanagement.supply.entity.Supply;
import com.buensabor.coffeemanagement.supply.repository.SupplyRepository;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.buensabor.coffeemanagement.tables.repository.TablesRepository;
import com.buensabor.coffeemanagement.user.entity.User;
import com.buensabor.coffeemanagement.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository repository;

    private final TablesRepository tableRepository;

    private final UserRepository userRepository;

    private final ProductSupplyRepository productSupplyRepository;

    private final SupplyRepository supplyRepository;

    public OrdersServiceImpl(OrdersRepository repository, TablesRepository tableRepository, UserRepository userRepository, ProductSupplyRepository productSupplyRepository, SupplyRepository supplyRepository) {

        this.repository = repository;
        this.tableRepository = tableRepository;
        this.userRepository = userRepository;
        this.productSupplyRepository = productSupplyRepository;
        this.supplyRepository = supplyRepository;
    }

    @Override
    public Orders create(Long tableId, Long waiterId) {

        Tables table = tableRepository.findById(tableId).orElseThrow();

        User waiter = userRepository.findById(waiterId).orElseThrow();

        Orders order = new Orders();

        order.setStatus(OrderStatus.CREATED);

        order.setTables(table);

        order.setWaiter(waiter);

        return repository.save(order);
    }

    @Override
    public Orders findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Orders> findAll() {

        return repository.findAll();
    }

    @Override
    public List<Orders> findByStatus(OrderStatus status) {

        return repository.findByStatus(status);
    }

    @Override
    public Orders startPreparation(Long orderId) {

        Orders order = findById(orderId);

        order.setStatus(OrderStatus.IN_PROGRESS);

        return repository.save(order);
    }

    @Override
    @Transactional
    public Orders ready(Long orderId) {

        Orders order = findById(orderId);

        if (order.getItems().isEmpty()) {

            throw new RuntimeException("Order has no items");
        }

        consumeSupplies(order);

        order.setStatus(OrderStatus.READY);

        return repository.save(order);
    }

    @Override
    public Orders delivered(Long orderId) {

        Orders order = findById(orderId);

        order.setStatus(OrderStatus.DELIVERED);

        return repository.save(order);
    }

    @Override
    public Orders close(Long orderId) {

        Orders order = findById(orderId);

        order.setStatus(OrderStatus.CLOSED);

        return repository.save(order);
    }

    private void consumeSupplies(Orders order) {

        for (OrderItem item : order.getItems()) {

            Product product = item.getProduct();

            List<ProductSupply> supplies = productSupplyRepository.findByProductId(product.getId());

            for (ProductSupply ps : supplies) {

                Supply supply = ps.getSupply();

                double quantityToConsume = ps.getQuantity() * item.getQuantity();

                if (supply.getStock() < quantityToConsume) {

                    throw new RuntimeException("Insufficient stock for supply: " + supply.getName());
                }

                supply.setStock((int) (supply.getStock() - quantityToConsume));

                supplyRepository.save(supply);
            }
        }
    }
}