package com.example.yiapp.ui.home.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yiapp.ui.home.model.Root;
import com.example.yiapp.ui.home.network.ApiInterface;
import com.example.yiapp.ui.home.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<Root> root;
    public HomeViewModel()
    {
        root = new MutableLiveData<>();
    }

    public void makeApiCall()
    {
        ApiInterface apiServices= RetrofitInstance.getRetroClient().create(ApiInterface.class);
        Call<Root> call = apiServices.getVerticalsList();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                root.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                root.postValue(null);
            }
        });

    }

    public MutableLiveData<Root> getVerticalsListObserver() {
        return root;
    }
}