package com.buensabor.coffeemanagement.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import com.buensabor.coffeemanagement.shared.BaseEntity;
import com.buensabor.coffeemanagement.product.entity.Product;

@Entity
public class OrderItem extends BaseEntity {

    @ManyToOne
    private Product product;

    private Integer quantity;

    private Double price; // precio congelado

    @ManyToOne
    private Orders order;

    public OrderItem() {
    }

    public OrderItem(
            Product product,
            Integer quantity,
            Double price,
            Orders order
    ) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
