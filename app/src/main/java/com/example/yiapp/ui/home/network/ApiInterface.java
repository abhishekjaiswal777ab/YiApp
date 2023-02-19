package com.example.yiapp.ui.home.network;

import com.example.yiapp.courses.modals.CourseRoot;
import com.example.yiapp.login.LoginResponse;
import com.example.yiapp.login.LoginSend;
import com.example.yiapp.ui.home.model.Root;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("/api/user/auth/verticals/all")  //route for all the verticals
    Call<Root> getVerticalsList();


    @POST("/api/user/auth/login")
    Call<LoginResponse> login(@Body LoginSend send);


    @GET
    Call<CourseRoot> getCourseList(@Url String url,@Header("auth-token") String token);
}
