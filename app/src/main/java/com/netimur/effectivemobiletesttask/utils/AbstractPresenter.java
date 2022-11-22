package com.netimur.effectivemobiletesttask.utils;

import com.netimur.effectivemobiletesttask.data.network.ApiService;
import com.netimur.effectivemobiletesttask.data.network.ApiServiceImplementation;
import com.netimur.effectivemobiletesttask.data.network.RetrofitApiProvider;

abstract public class AbstractPresenter {
    protected ApiService apiService = new ApiServiceImplementation(RetrofitApiProvider.getInstance().getApi());
}
