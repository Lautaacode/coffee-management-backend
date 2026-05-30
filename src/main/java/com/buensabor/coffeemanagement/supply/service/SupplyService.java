package com.buensabor.coffeemanagement.supply.service;

import com.buensabor.coffeemanagement.supply.entity.Supply;

import java.util.List;

public interface SupplyService {

    Supply create(Supply supply);

    List<Supply> findAll();
}