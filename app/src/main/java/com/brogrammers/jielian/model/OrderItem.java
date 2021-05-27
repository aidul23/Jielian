package com.brogrammers.jielian.model;

public class OrderItem {
    private String itemName;
    private int itemPrice, itemQuantity;

    public OrderItem(String itemName, int itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public OrderItem() {
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}
