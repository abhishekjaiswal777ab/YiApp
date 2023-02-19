package com.example.yiapp.ui.home;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.example.yiapp.R;
import com.example.yiapp.ui.home.adapter.VerticalsAdapter;
import com.example.yiapp.ui.home.model.ModelVertical;
import com.example.yiapp.ui.home.model.Root;
import com.example.yiapp.ui.home.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ImageSlider slider;
    RecyclerView recview;
    VerticalsAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    public List<ModelVertical> list;
    private HomeViewModel viewModel;

    @SuppressLint("NotifyDataSetChanged")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setUpRecyclerView(view);

        viewModel=new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getVerticalsListObserver().observe(getViewLifecycleOwner(), new Observer<Root>() {

            //called on change in the vertical list
            @Override
            public void onChanged(Root root) {
                if(root!=null)
                {
                    list=root.getAllVerticals();
                    adapter.setVerticalsList(root.getAllVerticals());
                }
            }
        });
        viewModel.makeApiCall();
        swipeRefreshLayout=view.findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            //function to refresh the page
            @Override
            public void onRefresh() {
                viewModel.makeApiCall();
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //this is arraylist of the images in the slides
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.image1, null));
        slideModels.add(new SlideModel(R.drawable.image2, null));
        slideModels.add(new SlideModel(R.drawable.image3, null));
        slider = view.findViewById(R.id.image_slider);
        slider.setImageList(slideModels, ScaleTypes.CENTER_CROP);

        return view;
    }

    public void setUpRecyclerView(View view)
    {   recview = view.findViewById(R.id.verticals_recview);
        recview.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        recview.setHasFixedSize(true);
        adapter = new VerticalsAdapter(list,view.getContext());
        recview.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}