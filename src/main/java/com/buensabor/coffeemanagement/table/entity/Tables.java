package com.buensabor.coffeemanagement.table.entity;

import jakarta.persistence.*;
import com.buensabor.coffeemanagement.order.entity.Orders;
import java.util.List;
import java.time.LocalDateTime; 

@Entity
@Table(name = "restaurant_tables")
public class Tables { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    
    public Long getId() { 
        return id;
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

    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}