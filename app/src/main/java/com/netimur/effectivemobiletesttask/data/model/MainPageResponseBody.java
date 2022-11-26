package com.netimur.effectivemobiletesttask.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


final public class MainPageResponseBody {
    @SerializedName("home_store")
    private final List<HotSales> homeStoreResponseBody;
    @SerializedName("best_seller")
    private final List<BestSeller> bestSellerResponseBody;

    public MainPageResponseBody(List<HotSales> homeStoreResponseBody, List<BestSeller> bestSellerResponseBody) {
        this.homeStoreResponseBody = homeStoreResponseBody;
        this.bestSellerResponseBody = bestSellerResponseBody;
    }

    public List<HotSales> getHomeStoreResponseBody() {
        return homeStoreResponseBody;
    }

    public List<BestSeller> getBestSellerResponseBody() {
        return bestSellerResponseBody;
    }
}
