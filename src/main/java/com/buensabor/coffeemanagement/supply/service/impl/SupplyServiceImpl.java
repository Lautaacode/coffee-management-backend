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
    public Supply findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Supply not found"));
    }

    @Override
    public List<Supply> findAll() {

        return repository.findAll();
    }

    @Override
    public Supply update(Long id, Supply supply) {

        Supply existing = findById(id);

        existing.setName(supply.getName());
        existing.setCost(supply.getCost());
        existing.setStock(supply.getStock());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {

        Supply supply = findById(id);

        repository.delete(supply);
    }

    @Override
    public Supply addStock(Long id, Integer quantity) {

        Supply supply = findById(id);

        supply.setStock(
                supply.getStock() + quantity
        );

        return repository.save(supply);
    }

    @Override
    public Supply removeStock(Long id, Integer quantity) {

        Supply supply = findById(id);

        if (supply.getStock() < quantity) {
            throw new RuntimeException(
                    "Insufficient stock"
            );
        }

        supply.setStock(
                supply.getStock() - quantity
        );

        return repository.save(supply);
    }
}