package com.buensabor.coffeemanagement.order.entity;

import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.BaseEntity;
import com.buensabor.coffeemanagement.table.entity.Table;
import com.buensabor.coffeemanagement.user.entity.User;

import java.util.List;

@Entity
public class Order extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private User waiter;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order() {
    }

    public Order(
            OrderStatus status,
            Table table,
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
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