package com.buensabor.coffeemanagement.orders.entity;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.buensabor.coffeemanagement.user.entity.User;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private User waiter;

    @ManyToOne
    @JoinColumn(name = "tables_id")
    private Tables tables;

    @JsonManagedReference("order-items")
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderItem> items = new ArrayList<>();

    public Orders() {
    }

    public Orders(
            OrderStatus status,
            User waiter,
            Tables tables,
            List<OrderItem> items
    ) {
        this.status = status;
        this.waiter = waiter;
        this.tables = tables;
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}