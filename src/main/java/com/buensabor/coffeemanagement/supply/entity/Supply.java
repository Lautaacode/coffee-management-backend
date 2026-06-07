package com.buensabor.coffeemanagement.supply.entity;

import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Supply extends BaseEntity {

    private String name;

    private Integer stock;

    private Double cost;

    @JsonManagedReference("supply-productSupply")
    @OneToMany(
            mappedBy = "supply"
    )
    private List<ProductSupply> products = new ArrayList<>();

    public Supply() {
    }

    public Supply(
            String name,
            Integer stock,
            Double cost,
            List<ProductSupply> products
    ) {
        this.name = name;
        this.stock = stock;
        this.cost = cost;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<ProductSupply> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSupply> products) {
        this.products = products;
    }
}
