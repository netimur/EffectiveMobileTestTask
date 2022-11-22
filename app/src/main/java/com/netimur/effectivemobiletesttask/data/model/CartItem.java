package com.netimur.effectivemobiletesttask.data.model;

public class CartItem {
    private final int id;
    private final String images;
    private final int price;
    private final String title;

    public CartItem(int id, String images, int price, String title) {
        this.id = id;
        this.images = images;
        this.price = price;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getImages() {
        return images;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
