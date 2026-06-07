package com.buensabor.coffeemanagement.orders.repository;

import com.buensabor.coffeemanagement.orders.entity.OrderStatus;
import com.buensabor.coffeemanagement.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByStatus(OrderStatus status);

    List<Orders> findByTablesId(Long tableId);

}