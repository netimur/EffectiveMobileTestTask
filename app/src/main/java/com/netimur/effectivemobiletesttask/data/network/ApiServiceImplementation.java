package com.netimur.effectivemobiletesttask.data.network;

import com.netimur.effectivemobiletesttask.data.model.DetailsResponseBody;
import com.netimur.effectivemobiletesttask.data.model.MainPageResponseBody;
import com.netimur.effectivemobiletesttask.data.model.MyCart;

import retrofit2.Call;

public class ApiServiceImplementation implements ApiService{
    private final Api api;

    public ApiServiceImplementation(Api api) {
        this.api = api;
    }

    @Override
    public void requestMainPageData(ApplicationResponseCallback callback) {
        Call<MainPageResponseBody> call = api.requestMainPageData();
        ApplicationServerResponseHandler<MainPageResponseBody> handler = new ApplicationServerResponseHandler<>(callback);
        call.enqueue(handler);
    }

    @Override
    public void requestDetails(ApplicationResponseCallback callback) {
        Call<DetailsResponseBody> call = api.requestDetails();
        ApplicationServerResponseHandler<DetailsResponseBody> handler = new ApplicationServerResponseHandler<>(callback);
        call.enqueue(handler);
    }

    @Override
    public void requestMyCart(ApplicationResponseCallback callback) {
        Call<MyCart> call = api.requestMyCart();
        ApplicationServerResponseHandler<MyCart> handler = new ApplicationServerResponseHandler<>(callback);
        call.enqueue(handler);
    }
}
