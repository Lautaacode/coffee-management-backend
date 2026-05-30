package com.buensabor.coffeemanagement.tables.service;

import com.buensabor.coffeemanagement.tables.entity.Tables;

public interface TablesService {

    Tables create(Tables table);

    Tables openTable(Long id);

    Tables closeTable(Long id);
}