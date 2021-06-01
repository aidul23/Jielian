package com.brogrammers.jielian.model;

public class OrderStatus {

    private String status, title;

    public OrderStatus() {
    }

    public OrderStatus(String status, String title) {
        this.status = status;
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
