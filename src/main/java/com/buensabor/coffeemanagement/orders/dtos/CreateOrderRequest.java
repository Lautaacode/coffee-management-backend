package com.buensabor.coffeemanagement.orders.dtos;

import com.buensabor.coffeemanagement.orderitem.dto.OrderItemRequest;

import java.util.List;

public class CreateOrderRequest {

    private Long tableId;

    private Long waiterId;

    private List<OrderItemRequest> items;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}