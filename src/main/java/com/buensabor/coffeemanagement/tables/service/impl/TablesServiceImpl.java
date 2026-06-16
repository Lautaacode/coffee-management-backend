package com.buensabor.coffeemanagement.tables.service.impl;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;
import com.buensabor.coffeemanagement.orders.entity.Orders;
import com.buensabor.coffeemanagement.tables.entity.TableStatus;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.buensabor.coffeemanagement.tables.repository.TablesRepository;
import com.buensabor.coffeemanagement.tables.service.TablesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesServiceImpl implements TablesService {

    private final TablesRepository repository;

    public TablesServiceImpl(TablesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tables create(Tables table) {

        table.setStatus(TableStatus.CLOSED);

        return repository.save(table);
    }

    @Override
    public Tables findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Table not found"));
    }

    @Override
    public List<Tables> findAll() {

        return repository.findAll();
    }

    @Override
    public Tables update(Long id, Tables table) {

        Tables existing = findById(id);

        existing.setNumber(table.getNumber());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {

        Tables table = findById(id);

        repository.delete(table);
    }

    @Override
    public Tables openTable(Long id) {

        Tables table = findById(id);

        if (table.getStatus() == TableStatus.OPEN) {
            throw new RuntimeException(
                    "Table is already open"
            );
        }

        table.setStatus(TableStatus.OPEN);

        return repository.save(table);
    }

    @Override
    public Tables closeTable(Long id) {

        Tables table = findById(id);

        if (table.getStatus() == TableStatus.CLOSED) {
            throw new RuntimeException(
                    "Table is already closed"
            );
        }

        table.setStatus(TableStatus.CLOSED);

        return repository.save(table);
    }

    @Override
    public Double calculateTotal(Long tableId) {

        Tables table = findById(tableId);

        return table.getOrders()
                .stream()
                .flatMap(order ->
                        order.getItems().stream())
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    @Override
    public List<Orders> getOrders(Long tableId) {

        return findById(tableId)
                .getOrders();
    }
}