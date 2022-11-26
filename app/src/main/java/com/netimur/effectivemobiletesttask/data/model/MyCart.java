package com.netimur.effectivemobiletesttask.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

final public class MyCart {
    @SerializedName("basket")
    private final List<CartItem> cartItems;
    private final String delivery;
    private final String id;
    private final int total;

    public MyCart(List<CartItem> cartItems, String delivery, String id, int total) {
        this.cartItems = cartItems;
        this.delivery = delivery;
        this.id = id;
        this.total = total;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }
}
