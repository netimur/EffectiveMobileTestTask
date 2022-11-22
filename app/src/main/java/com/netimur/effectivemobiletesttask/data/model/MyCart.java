package com.netimur.effectivemobiletesttask.data.model;

import java.util.ArrayList;

public class MyCart {
    private final ArrayList<CartItem> cartItems;
    private final String delivery;
    private final String id;
    private final int total;

    public MyCart(ArrayList<CartItem> cartItems, String delivery, String id, int total) {
        this.cartItems = cartItems;
        this.delivery = delivery;
        this.id = id;
        this.total = total;
    }
}
