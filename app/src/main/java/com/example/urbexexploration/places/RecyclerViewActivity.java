package com.example.urbexexploration.places;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityAboutBinding;
import com.example.urbexexploration.databinding.ActivityRecyclerBinding;
import com.example.urbexexploration.onePlace.OnePlaceActivity;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecycleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<CardItem> recyclerList;
    private ActivityRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createRecyclerList();
        createRecyclerView();

        binding.recyclerSearchTask.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }

    public void filter(String txt) {
        ArrayList<CardItem> filteredList = new ArrayList<>();

        for (CardItem item : recyclerList) {
            if (item.getText2().toLowerCase().contains(txt.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    public void createRecyclerList() {
        recyclerList = new ArrayList<>();
        recyclerList.add(new CardItem(R.drawable.inne, "line1", "line2"));
        recyclerList.add(new CardItem(R.drawable.logo1, "line3", "line4"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));
        recyclerList.add(new CardItem(R.drawable.zamki, "line5", "line6"));


    }

    public void createRecyclerView() {
        binding.recyclerRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecycleAdapter(recyclerList);

        binding.recyclerRecyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerRecyclerView.setAdapter(mAdapter);
    }




    public void onClickToOnePlaceActivity(View v) {   // uzyto on Click w designie na imageView w ITEM
        Intent intent = new Intent(this, OnePlaceActivity.class);
        startActivity(intent);
    }
}