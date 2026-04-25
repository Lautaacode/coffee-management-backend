package com.buensabor.coffeemanagement.table.entity;

import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.BaseEntity;
import com.buensabor.coffeemanagement.order.entity.Order;

import java.util.List;

@Entity
public class Table extends BaseEntity {

    private Integer number;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;

    public Table() {
    }

    public Table(
            Integer number,
            TableStatus status,
            List<Order> orders
    ) {
        this.number = number;
        this.status = status;
        this.orders = orders;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}