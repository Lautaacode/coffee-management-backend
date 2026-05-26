package com.buensabor.coffeemanagement.table.service;

import com.buensabor.coffeemanagement.table.entity.Tables;
import com.buensabor.coffeemanagement.table.entity.TableStatus;
import com.buensabor.coffeemanagement.table.repository.TablesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TablesService {

    private final TablesRepository tablesRepository;

    public TablesService(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
    }

    public List<Tables> getAllTables() {
        return tablesRepository.findAll();
    }

    public Tables getTableById(Long id) {
        return tablesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con ID: " + id));
    }

    public Tables saveTable(Tables table) {
        return tablesRepository.save(table);
    }
    public Tables updateTableStatus(Long id, TableStatus newStatus) {
        Tables table = getTableById(id);
        table.setStatus(newStatus);
        return tablesRepository.save(table);
    }
}