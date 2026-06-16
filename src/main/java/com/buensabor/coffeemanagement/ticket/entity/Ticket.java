package com.buensabor.coffeemanagement.ticket.entity;

import com.buensabor.coffeemanagement.payment.entity.Payment;
import com.buensabor.coffeemanagement.shared.entity.BaseEntity;
import com.buensabor.coffeemanagement.tables.entity.Tables;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Ticket extends BaseEntity {

    private Double total;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    private Tables tables;

    public Ticket() {
    }

    public Ticket(
            Double total,
            Payment payment,
            Tables tables
    ) {
        this.total = total;
        this.payment = payment;
        this.tables = tables;
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

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }
}