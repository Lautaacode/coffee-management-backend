package com.buensabor.coffeemanagement.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import com.buensabor.coffeemanagement.shared.BaseEntity;

@Entity
public class Product extends BaseEntity {

    private String name;
    private String description;

    private Double price;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    private Integer stock;

    private boolean active = true; // soft delete

    public Product() {
    }

    public Product(
            String name,
            String description,
            Double price,
            ProductCategory category,
            Integer stock,
            boolean active
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}