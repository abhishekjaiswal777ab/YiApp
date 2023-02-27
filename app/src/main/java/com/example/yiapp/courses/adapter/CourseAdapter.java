package com.example.yiapp.courses.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yiapp.courses.CourseActivity;
import com.example.yiapp.courses.VideosActivity;
import com.example.yiapp.courses.modals.ModelCourse;
import com.example.yiapp.databinding.SingleCourseBinding;
import com.example.yiapp.databinding.SingleVerticalBinding;
import com.example.yiapp.ui.home.adapter.VerticalsAdapter;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.myHolder> {

    List<ModelCourse> list;
    Context context;

    public CourseAdapter(List<ModelCourse> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SingleCourseBinding binding = SingleCourseBinding.inflate(inflater,parent,false);
        return new myHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
         final ModelCourse model=list.get(position);
         holder.singleCourseBinding.courseName.setText(model.getName());
         holder.singleCourseBinding.courseDesc.setText(model.getDesc());
         holder.singleCourseBinding.totalUnits.setText(Integer.toString(model.getUnitArr().size()));

         holder.singleCourseBinding.viewUnitButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(context, VideosActivity.class);
                 intent.putExtra("course_name",model.getName());
                 intent.putExtra("course_description",model.getDesc());
                 intent.putExtra("listOfCourses",model.getUnitArr());
                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        if(this.list!=null)
        {
            return this.list.size();
        }
        return 0;
    }

    public class myHolder extends RecyclerView.ViewHolder{

        SingleCourseBinding singleCourseBinding;
        public myHolder(@NonNull SingleCourseBinding singleCourseBinding) {
            super(singleCourseBinding.getRoot());
            this.singleCourseBinding = singleCourseBinding;
        }
    }
}
