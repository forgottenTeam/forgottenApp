package com.example.urbexexploration.places;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.databinding.ActivityPlaceListBinding;
import com.example.urbexexploration.onePlace.OnePlaceActivity;

import java.util.ArrayList;
import java.util.List;

public class PlaceListActivity extends AppCompatActivity {
    private RecycleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ActivityPlaceListBinding binding;
    private PlaceListViewModel placeListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String category = getIntent().getStringExtra("EXTRA_CATEGORY");
        binding = ActivityPlaceListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createRecyclerView();

        placeListViewModel = new ViewModelProvider(this).get(PlaceListViewModel.class);

        placeListViewModel.getPlacesLiveData().observe(this, placeList -> {

           mAdapter.submitList(placeList);

            if (category!=null){
                placeListViewModel.filterListCategory(category);
            } else {
                Toast.makeText(PlaceListActivity.this,"nie maaaaaaaaaaaaaaaaa",Toast.LENGTH_LONG).show();
            }
        });

        placeListViewModel.getFilteredPlacesLiveData().observe(this, placeList -> {
            mAdapter.submitList(placeList);
        });





        binding.placeListSearchTask.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                placeListViewModel.filter(s.toString());
            }
        });


    }

    public void createRecyclerView() {
        binding.placeListRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecycleAdapter();

        binding.placeListRecyclerView.setLayoutManager(mLayoutManager);
        binding.placeListRecyclerView.setAdapter(mAdapter);
    }

    public void onClickToOnePlaceActivity(View v) {   // uzyto on Click w designie na imageView w ITEM
        Intent intent = new Intent(this, OnePlaceActivity.class);
        startActivity(intent);
    }
}