package com.netimur.effectivemobiletesttask.data.network;


import com.netimur.effectivemobiletesttask.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

final public class RetrofitApiProvider {
    private static volatile RetrofitApiProvider instance;
    private final Api api;

    private RetrofitApiProvider(Api api) {
        this.api = api;
    }

    public static RetrofitApiProvider getInstance() {
        RetrofitApiProvider retrofitApiProvider = instance;
        if (retrofitApiProvider != null) {
            return instance;
        }
        synchronized (RetrofitApiProvider.class) {
            if (instance == null) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create(Api.class);
                instance = new RetrofitApiProvider(api);
            }
            return instance;
        }
    }

    public Api getApi() {
        return api;
    }
}
