package com.buensabor.coffeemanagement.tables.service;

import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.tables.entity.Tables;

import java.util.List;

public interface TablesService {

    Tables create(Tables table);

    Tables findById(Long id);

    List<Tables> findAll();

    Tables update(Long id, Tables table);

    void delete(Long id);

    Tables openTable(Long id);

    Tables closeTable(Long id);

    Double calculateTotal(Long tableId);

    List<Orders> getOrders(Long tableId);

}