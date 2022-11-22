package com.netimur.effectivemobiletesttask.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

final public class MainPageResponseBody {
    @SerializedName("home_store")
    private final ArrayList<HotSales> homeStoreResponseBody;
    @SerializedName("best_seller")
    private final ArrayList<BestSeller> bestSellerResponseBody;

    public MainPageResponseBody(ArrayList<HotSales> homeStoreResponseBody, ArrayList<BestSeller> bestSellerResponseBody) {
        this.homeStoreResponseBody = homeStoreResponseBody;
        this.bestSellerResponseBody = bestSellerResponseBody;
    }

    public ArrayList<HotSales> getHomeStoreResponseBody() {
        return homeStoreResponseBody;
    }

    public ArrayList<BestSeller> getBestSellerResponseBody() {
        return bestSellerResponseBody;
    }
}
