package com.netimur.effectivemobiletesttask.data.network;

import retrofit2.Call;
import retrofit2.http.GET;

import com.netimur.effectivemobiletesttask.data.model.DetailsResponseBody;
import com.netimur.effectivemobiletesttask.data.model.MainPageResponseBody;
import com.netimur.effectivemobiletesttask.data.model.MyCart;
import com.netimur.effectivemobiletesttask.utils.Constants;

public interface Api {
    @GET(Constants.MAIN_PAGE_REQUEST_ENDPOINT)
    Call<MainPageResponseBody> requestMainPageData();

    @GET(Constants.DETAILS_REQUEST_ENDPOINT)
    Call<DetailsResponseBody> requestDetails();

    @GET(Constants.MY_CART_REQUEST_ENDPOINT)
    Call<MyCart> requestMyCart();
}
