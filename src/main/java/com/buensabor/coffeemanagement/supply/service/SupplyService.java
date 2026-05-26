package com.buensabor.coffeemanagement.supply.service;

import com.buensabor.coffeemanagement.supply.entity.Supply;
import com.buensabor.coffeemanagement.supply.repository.SupplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    public Supply getSupplyById(Long id) {
        return supplyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado con ID: " + id));
    }

    @Transactional
    public Supply saveSupply(Supply supply) {
        return supplyRepository.save(supply);
    }
}