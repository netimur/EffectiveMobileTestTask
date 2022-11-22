package com.netimur.effectivemobiletesttask.data.network;


public interface ApplicationResponseCallback {
    <T> void onSuccess(T body);
    void onError();
}
