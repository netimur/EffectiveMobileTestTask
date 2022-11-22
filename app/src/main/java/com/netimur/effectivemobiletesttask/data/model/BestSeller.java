package com.netimur.effectivemobiletesttask.data.model;


import com.google.gson.annotations.SerializedName;

final public class BestSeller  {
    private final int id;
    @SerializedName("is_favorites")
    private final boolean isFavorites;
    private final String title;
    @SerializedName("price_without_discount")
    private final int priceWithoutDiscount;
    @SerializedName("discount_price")
    private final int discountPrice;
    @SerializedName("picture")
    private final String pictureUrl;

    public BestSeller(int id, boolean isFavorites, String title, int priceWithoutDiscount, int discountPrice, String pictureUrl) {
        this.id = id;
        this.isFavorites = isFavorites;
        this.title = title;
        this.priceWithoutDiscount = priceWithoutDiscount;
        this.discountPrice = discountPrice;
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public boolean isFavorites() {
        return isFavorites;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceWithoutDiscount() {
        return priceWithoutDiscount;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }
}
