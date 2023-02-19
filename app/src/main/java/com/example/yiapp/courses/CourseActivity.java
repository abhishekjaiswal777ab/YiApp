package com.example.yiapp.courses;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yiapp.courses.modals.ModelCourse;
import com.example.yiapp.courses.modals.CourseRoot;
import com.example.yiapp.databinding.ActivityCourseBinding;
import com.example.yiapp.ui.home.network.ApiInterface;
import com.example.yiapp.ui.home.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {

    ActivityCourseBinding binding;
    String authToken=getIntent().getStringExtra("token");
    List<ModelCourse> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Call<CourseRoot> call= RetrofitInstance.getRetroClient().create(ApiInterface.class).getCourseList("/api/user/auth/"+getIntent().getStringExtra("id"),authToken);
        call.enqueue(new Callback<CourseRoot>() {
            @Override
            public void onResponse(Call<CourseRoot> call, Response<CourseRoot> response) {
                CourseRoot root=response.body();
                list=root.getAllCourses();
                if(response.isSuccessful())
                {
                    Log.v("kuch ", "successful");
                }
            }

            @Override
            public void onFailure(Call<CourseRoot> call, Throwable t) {

            }
        });
    }

}