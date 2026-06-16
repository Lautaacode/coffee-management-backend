package com.buensabor.coffeemanagement.product.entity;


import com.buensabor.coffeemanagement.productsupply.entity.ProductSupply;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product extends BaseEntity {

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private boolean active = true;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @JsonIgnore
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductSupply> supplies = new ArrayList<>();

    public Product() {
    }

    public Product(
            String name,
            String description,
            Double price,
            Integer stock,
            boolean active,
            ProductCategory category,
            List<ProductSupply> supplies
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.active = active;
        this.category = category;
        this.supplies = supplies;
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

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<ProductSupply> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<ProductSupply> supplies) {
        this.supplies = supplies;
    }
}