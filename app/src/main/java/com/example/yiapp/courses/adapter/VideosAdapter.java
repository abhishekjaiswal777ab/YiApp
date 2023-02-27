package com.example.yiapp.courses.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yiapp.courses.modals.ModelAllUnits;
import com.example.yiapp.databinding.SingleVideoBinding;

import java.util.ArrayList;
import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.myHolder> {

    ArrayList<ModelAllUnits> list;
    Context context;

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
