package com.buensabor.coffeemanagement.supply.service;

import com.buensabor.coffeemanagement.supply.entity.ProductSupply;
import com.buensabor.coffeemanagement.supply.entity.Supply;
import com.buensabor.coffeemanagement.supply.repository.ProductSupplyRepository;
import com.buensabor.coffeemanagement.supply.repository.SupplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductSupplyService {

    private final ProductSupplyRepository productSupplyRepository;
    private final SupplyRepository supplyRepository;

    public ProductSupplyService(ProductSupplyRepository productSupplyRepository, SupplyRepository supplyRepository) {
        this.productSupplyRepository = productSupplyRepository;
        this.supplyRepository = supplyRepository;
    }

    public List<ProductSupply> getRecipeByProductId(Long productId) {
        return productSupplyRepository.findByProduct_Id(productId);
    }

    @Transactional
    public ProductSupply saveProductSupply(ProductSupply productSupply) {
        return productSupplyRepository.save(productSupply);
    }

    @Transactional
    public void discountStockForProduct(Long productId, int quantitySold) {
        List<ProductSupply> recipe = productSupplyRepository.findByProduct_Id(productId);

        for (ProductSupply item : recipe) {
            Supply supply = item.getSupply();
            
            if (supply != null) {
                Double totalToDiscount = item.getQuantity() * quantitySold;
                
                Double currentStock = supply.getStock().doubleValue();
                
                if (currentStock < totalToDiscount) {
                    throw new RuntimeException("Stock insuficiente en depósito para el insumo: " + supply.getName());
                }
                
                double newStockDouble = currentStock - totalToDiscount;
                Integer newStockInteger = (int) Math.round(newStockDouble);
                
                supply.setStock(newStockInteger);
                supplyRepository.save(supply);
            }
        }
    }
}