package com.buensabor.coffeemanagement.tables.dto;

import com.buensabor.coffeemanagement.tables.entity.TableStatus;

public class TablesResponse {

    private Long id;

    private Integer number;

    private TableStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}