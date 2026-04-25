package com.buensabor.coffeemanagement.ticket.entity;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.shared.BaseEntity;
import com.buensabor.coffeemanagement.table.entity.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Ticket extends BaseEntity {

    private Double total;

    @OneToOne
    private Payment payment;

    @ManyToOne
    private Table table;

    public Ticket() {
    }

    public Ticket(
            Double total,
            Payment payment,
            Table table
    ) {
        this.total = total;
        this.payment = payment;
        this.table = table;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}