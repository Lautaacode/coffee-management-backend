package com.buensabor.coffeemanagement.supply.service.impl;

import com.buensabor.coffeemanagement.supply.entity.Supply;
import com.buensabor.coffeemanagement.supply.repository.SupplyRepository;
import com.buensabor.coffeemanagement.supply.service.SupplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository repository;

    public SupplyServiceImpl(SupplyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Supply create(Supply supply) {
        return repository.save(supply);
    }

    @Override
    public List<Supply> findAll() {
        return repository.findAll();
    }

    public Supply findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supply not found"));
    }

    public Supply update(Long id, Supply supply) {
        Supply existing = findById(id);

        existing.setName(supply.getName());
        existing.setStock(supply.getStock());
        existing.setCost(supply.getCost());

        return repository.save(existing);
    }
}