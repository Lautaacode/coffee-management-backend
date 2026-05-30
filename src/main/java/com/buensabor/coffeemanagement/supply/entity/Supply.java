package com.buensabor.coffeemanagement.supply.entity;

import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import jakarta.persistence.Entity;


@Entity
public class Supply extends BaseEntity {

    private String name;
    private Integer stock;
    private Double cost;

    public Supply() {
    }

    public Supply(String name, Integer stock, Double cost) {
        this.name = name;
        this.stock = stock;
        this.cost = cost;
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
}
