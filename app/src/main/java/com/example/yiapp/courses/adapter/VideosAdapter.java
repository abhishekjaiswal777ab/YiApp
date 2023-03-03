package com.example.yiapp.courses.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yiapp.YtubeVideo.YouTubeActivity;
import com.example.yiapp.courses.VideosActivity;
import com.example.yiapp.courses.modals.ModelAllUnits;
import com.example.yiapp.databinding.SingleVideoBinding;

import java.util.ArrayList;
import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.myHolder> {

    ArrayList<ModelAllUnits> list;
    Context context;

    TextView textView;

    public VideosAdapter(ArrayList<ModelAllUnits> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SingleVideoBinding binding=SingleVideoBinding.inflate(inflater,parent,false);
        return new myHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        final ModelAllUnits model=list.get(position);
        holder.singleVideoBinding.videoText.setText(model.getVideo().getTitle());

        holder.singleVideoBinding.videoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YouTubeActivity.class);
                intent.putExtra("Questions",model.getQuiz());

                intent.putExtra("VideoSource" , model.getVideo().getVdoSrc());
                intent.putExtra("Description" , model.getVideo().getDesc());
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

    public static class myHolder extends RecyclerView.ViewHolder{

        SingleVideoBinding singleVideoBinding;
        public myHolder(@NonNull SingleVideoBinding singleVideoBinding) {
            super(singleVideoBinding.getRoot());
            this.singleVideoBinding=singleVideoBinding;
        }
    }
}
