package com.netimur.effectivemobiletesttask.data.network;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

final public class ApplicationServerResponseHandler<T> implements Callback<T> {
    private final ApplicationResponseCallback callback;

    public ApplicationServerResponseHandler(ApplicationResponseCallback callback) {
        this.callback = callback;
    }

    void handleResponse(Response<T> response) {
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            callback.onError();
        }
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        handleResponse(response);
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        callback.onError();
    }
}
