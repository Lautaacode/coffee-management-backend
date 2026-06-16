package com.buensabor.coffeemanagement.orders.entity;

import com.buensabor.coffeemanagement.orderitem.entity.OrderItem;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.buensabor.coffeemanagement.users.entity.Users;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private Users waiter;

    @ManyToOne
    @JoinColumn(name = "tables_id")
    @JsonManagedReference("table-orders")
    private Tables tables;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    @JsonBackReference("order-items")
    private List<OrderItem> items = new ArrayList<>();

    public Orders() {
    }

    public Orders(
            OrderStatus status,
            Users waiter,
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

    public Users getWaiter() {
        return waiter;
    }

    public void setWaiter(Users waiter) {
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