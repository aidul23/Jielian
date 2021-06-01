package com.brogrammers.jielian.model;

public class Order {

    private String orderId, orderDateTime, pickupAddress, destinationAddress, orderStatus;
            int orderTotalCost;

    public Order(String orderId, String orderDateTime, String pickupAddress, String destinationAddress, String orderStatus, int orderTotalCost) {
        this.orderId = orderId;
        this.orderDateTime = orderDateTime;
        this.pickupAddress = pickupAddress;
        this.destinationAddress = destinationAddress;
        this.orderStatus = orderStatus;
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

    public String getPickupAddress() {
        return pickupAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
