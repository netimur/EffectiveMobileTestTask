package com.netimur.effectivemobiletesttask.ui.mainpage;

import android.util.Log;

import com.netimur.effectivemobiletesttask.data.model.MainPageResponseBody;
import com.netimur.effectivemobiletesttask.data.network.ApplicationResponseCallback;
import com.netimur.effectivemobiletesttask.utils.AbstractPresenter;

public class MainPagePresenterImplementation extends AbstractPresenter implements MainPagePresenter, ApplicationResponseCallback {
    private final MainPageView view;

    public MainPagePresenterImplementation(MainPageView view) {
        this.view = view;
    }

    @Override
    public void requestMainPageData() {
        apiService.requestMainPageData(this);
    }

    @Override
    public <T> void onSuccess(T body) {
        MainPageResponseBody responseBody = (MainPageResponseBody) body;
        view.showBestSellers(responseBody.getBestSellerResponseBody());
        view.showHotSales(responseBody.getHomeStoreResponseBody());
    }

    @Override
    public void onError() {
        Log.d(this.getClass().toString(), "ERROR OCCURRED");
    }
}
