package com.buensabor.coffeemanagement.productsupply.entity;

import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.buensabor.coffeemanagement.supply.entity.Supply;
import jakarta.persistence.*;
import com.buensabor.coffeemanagement.product.entity.Product;

@Entity
public class ProductSupply extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supply_id")
    private Supply supply;

    private Double quantity;

    public ProductSupply() {
    }

    public ProductSupply(
            Product product,
            Supply supply,
            Double quantity
    ) {
        this.product = product;
        this.supply = supply;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}