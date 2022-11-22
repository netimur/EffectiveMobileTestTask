package com.netimur.effectivemobiletesttask.data.network;

public interface ApiService {
    void requestMainPageData(ApplicationResponseCallback callback);
    void requestDetails(ApplicationResponseCallback callback);
    void requestMyCart(ApplicationResponseCallback callback);
}
