package com.example.yiapp.courses;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.yiapp.R;
import com.example.yiapp.courses.adapter.CourseAdapter;
import com.example.yiapp.courses.modals.CourseRoot;
import com.example.yiapp.courses.modals.ModelCourse;
import com.example.yiapp.databinding.ActivityCourseBinding;
import com.example.yiapp.ui.home.network.ApiInterface;
import com.example.yiapp.ui.home.network.RetrofitInstance;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {

    ActivityCourseBinding binding;
    List<ModelCourse> list;
    RecyclerView recview;
    CourseAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    //shimmer initialized
    private ShimmerFrameLayout shimmerFrameLayout;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding=ActivityCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.verticalName.setText(getIntent().getStringExtra("name"));
        binding.verticalDesc.setText(getIntent().getStringExtra("description"));

        //shemmer effect called
        shimmerFrameLayout = findViewById(R.id.course_shimmer);

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        String auth_token=sp.getString("token","");
        Call<CourseRoot> call= RetrofitInstance.getRetroClient().create(ApiInterface.class).getCourseList("/api/user/auth/verticals/"+getIntent().getStringExtra("id")+"/courses/all",auth_token);
        call.enqueue(new Callback<CourseRoot>() {

            @Override

            public void onResponse(Call<CourseRoot> call, Response<CourseRoot> response) {


                CourseRoot root=response.body();
                list=root.getAllCourses();
                if(response.isSuccessful())
                {
                    //shemmer stopped and recview got visible
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    setUpRecyclerView(CourseActivity.this);
                    recview.setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void onFailure(Call<CourseRoot> call, Throwable t) {
                  Log.v("kuch" ,"not successful");
            }
        });

        swipeRefreshLayout=findViewById(R.id.swipeforcourses);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            //function to refresh the page
            @Override
            public void onRefresh() {

                //shemer function started after refresh bar --->
                shimmerFrameLayout.setVisibility(View.VISIBLE);
                recview.setVisibility(View.GONE);
                shimmerFrameLayout.startShimmer();

                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

                //shemer function get's stopped after updating data --->
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                recview.setVisibility(View.VISIBLE);


            }
        });


    }
    private void setUpRecyclerView(Context context)
    {   recview = findViewById(R.id.recview_course);
        recview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recview.setHasFixedSize(true);
        adapter = new CourseAdapter(list,context);
        recview.setAdapter(adapter);
    }

}