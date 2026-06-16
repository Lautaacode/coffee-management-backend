package com.buensabor.coffeemanagement.supply.service;

import com.buensabor.coffeemanagement.supply.entity.Supply;

import java.util.List;

public interface SupplyService {

    Supply create(Supply supply);

    Supply findById(Long id);

    List<Supply> findAll();

    Supply update(Long id, Supply supply);

    void delete(Long id);

    Supply addStock(Long id, Integer quantity);

    Supply removeStock(Long id, Integer quantity);

}