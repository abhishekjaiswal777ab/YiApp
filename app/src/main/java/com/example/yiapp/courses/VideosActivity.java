package com.example.yiapp.courses;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yiapp.R;
import com.example.yiapp.courses.adapter.VideosAdapter;
import com.example.yiapp.courses.modals.ModelAllUnits;
import com.example.yiapp.databinding.ActivityVideosBinding;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {

    RecyclerView recview;
    VideosAdapter adapter;
    ArrayList<ModelAllUnits> list;
    ActivityVideosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityVideosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.courseHeading.setText(getIntent().getStringExtra("course_name"));
        binding.courseDescription.setText(getIntent().getStringExtra("course_description"));

        list=(ArrayList<ModelAllUnits>)getIntent().getSerializableExtra("listOfCourses");
        Log.v("kuch to",list.get(0).getVideo().getTitle());

        recview = findViewById(R.id.recview_video);
        recview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recview.setHasFixedSize(true);
        adapter = new VideosAdapter(list,this);
        recview.setAdapter(adapter);
    }
}