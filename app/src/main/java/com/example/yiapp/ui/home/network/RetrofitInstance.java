package com.example.yiapp.ui.home.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//creating the instance of retrofit library

public class RetrofitInstance {
    public static Retrofit retrofit;
    public ApiInterface apiInterface;
    public static String api="https://yuva-backend.onrender.com";

    public static Retrofit getRetroClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(api)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
