package com.brogrammers.jielian.model;

public class Order {

    private String orderId, orderDateTime;
            int orderTotalCost;

    public Order(String orderId, String orderDateTime, int orderTotalCost) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
        this.orderTotalCost = orderTotalCost;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public int getOrderTotalCost() {
        return orderTotalCost;
    }
}
