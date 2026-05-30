package com.buensabor.coffeemanagement.tables.service.impl;

import com.buensabor.coffeemanagement.tables.entity.TableStatus;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.buensabor.coffeemanagement.tables.repository.TablesRepository;
import com.buensabor.coffeemanagement.tables.service.TablesService;
import org.springframework.stereotype.Service;

@Service
public class TablesServiceImpl implements TablesService {

    private final TablesRepository repository;

    public TablesServiceImpl(TablesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tables create(Tables table) {
        return repository.save(table);
    }

    @Override
    public Tables openTable(Long id) {
        Tables table = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found"));

        table.setStatus(TableStatus.OPEN);
        return repository.save(table);
    }

    @Override
    public Tables closeTable(Long id) {
        Tables table = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Table not found"));

        table.setStatus(TableStatus.CLOSED);
        return repository.save(table);
    }
}