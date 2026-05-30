package com.buensabor.coffeemanagement.orders.entity;

import com.buensabor.coffeemanagement.tables.entity.Tables;
import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.buensabor.coffeemanagement.user.entity.User;


import java.util.List;

@Entity
public class Orders extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Tables table;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private User waiter;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Orders() {
    }

    public Orders(
            OrderStatus status,
            Tables table,
            User waiter,
            List<OrderItem> items
    ) {
        this.status = status;
        this.table = table;
        this.waiter = waiter;
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}