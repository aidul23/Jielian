package com.brogrammers.jielian.model;

import java.io.Serializable;

public class CategoryItem implements Serializable {

    private final String title,
            imageUrl,
            description;

    private int price;

    public CategoryItem(String title, String imageUrl, String description, int price) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
