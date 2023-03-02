package com.example.yiapp.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yiapp.courses.CourseActivity;
import com.example.yiapp.databinding.SingleVerticalBinding;
import com.example.yiapp.ui.home.model.ModelVertical;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VerticalsAdapter extends RecyclerView.Adapter<VerticalsAdapter.myHolder>
{

    float v = 0;
    List<ModelVertical> modelVerticals;
    Context context;
    public VerticalsAdapter(List<ModelVertical> modelVerticals, Context context) {
        this.modelVerticals = modelVerticals;
        this.context=context;
    }
    public void setVerticalsList(List<ModelVertical> modelVerticals)
    {
        this.modelVerticals=modelVerticals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SingleVerticalBinding binding = SingleVerticalBinding.inflate(inflater,parent,false);
        return new myHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalsAdapter.myHolder holder, int position) {
           final ModelVertical model=modelVerticals.get(position);
           holder.singleVerticalBinding.t1.setText(modelVerticals.get(position).getName());
           holder.singleVerticalBinding.t2.setText(modelVerticals.get(position).getDesc());

           Picasso.get().load(model.getImgSrc()).into(holder.singleVerticalBinding.img1);

        //edit Start

        //Animation Start
//
//        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
//        holder.itemView.startAnimation(animation);



        holder.singleVerticalBinding.DropdownDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modelVerticals.get(position).isVisible)
                {
                    holder.singleVerticalBinding.t2.setVisibility(View.GONE);
                    modelVerticals.get(position).isVisible = false;
                    holder.singleVerticalBinding.DropdownDesc.setRotationY(180);
                    holder.singleVerticalBinding.DropdownDesc.setVisibility(View.VISIBLE);
                }
                else
                {
                    holder.singleVerticalBinding.t2.setVisibility(View.VISIBLE);
                    modelVerticals.get(position).isVisible = true;
                    holder.singleVerticalBinding.DropdownDesc.setRotationY(180);
                    holder.singleVerticalBinding.DropdownDesc.setVisibility(View.VISIBLE);
                }
            }
        });

        //edit End


        holder.singleVerticalBinding.t1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent=new Intent(context, CourseActivity.class);
                   intent.putExtra("name",model.getName());
                   intent.putExtra("description",model.getDesc());
                   intent.putExtra("id",model.get_id());
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);
               }
           });
    }

    @Override
    public int getItemCount() {
        if(this.modelVerticals!=null)
        {
            return this.modelVerticals.size();
        }
        return 0;
    }

    public class myHolder extends RecyclerView.ViewHolder {

        SingleVerticalBinding singleVerticalBinding;
        public myHolder(@NonNull SingleVerticalBinding singleVerticalBinding) {
            super(singleVerticalBinding.getRoot());
            this.singleVerticalBinding=singleVerticalBinding;
        }
    }
}
