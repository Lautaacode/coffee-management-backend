package com.buensabor.coffeemanagement.tables.entity;

import jakarta.persistence.*;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.buensabor.coffeemanagement.orders.entity.Orders;

import java.util.List;

@Entity
@Table(name = "restaurant_tables")
public class Tables extends BaseEntity {

    private Integer number;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @OneToMany(mappedBy = "table")
    private List<Orders> orders;

    public Tables() {
    }

    public Tables(
            Integer number,
            TableStatus status,
            List<Orders> orders
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

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}