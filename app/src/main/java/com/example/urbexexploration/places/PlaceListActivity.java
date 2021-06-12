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

import com.example.urbexexploration.addPlace.AddPlaceActivity;
import com.example.urbexexploration.databinding.ActivityPlaceListBinding;
import com.example.urbexexploration.onePlace.OnePlaceActivity;

/**
 * Klasa widoku listy miejsc, wyświetlanych jako "cardViews"
 * @author Paulina Bogusz
 */
public class PlaceListActivity extends AppCompatActivity {
    private RecycleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ActivityPlaceListBinding binding;
    private PlaceListViewModel placeListViewModel;

    private OnPlaceClickListener placeListener = new OnPlaceClickListener() {
        @Override
        public void onPlaceClick(int id) {
            onClickToOnePlaceActivity(id);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String category = getIntent().getStringExtra("EXTRA_CATEGORY");
        String province = getIntent().getStringExtra("EXTRA_PROVINCE");
        binding = ActivityPlaceListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        createRecyclerView();

        binding.recyclerAddButton.setOnClickListener(v -> onClickToAddButtonActivity(v));

        placeListViewModel = new ViewModelProvider(this).get(PlaceListViewModel.class);
        placeListViewModel.getPlacesLiveData().observe(this, placeList -> {

            mAdapter.submitList(placeList);

            if (category != null) {
                placeListViewModel.filterListCategory(category);
                Toast.makeText(PlaceListActivity.this, "Kategoria "+category, Toast.LENGTH_SHORT).show();
            } else if
            (province != null) {
                placeListViewModel.filterListProvince(province);
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

    /**
     * Tworzenie recyclerView - inicjalizacja widoku listy będącej kontenerem dla {@link ItemViewHolder}
     */
    public void createRecyclerView() {
        binding.placeListRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecycleAdapter(placeListener);

        binding.placeListRecyclerView.setLayoutManager(mLayoutManager);
        binding.placeListRecyclerView.setAdapter(mAdapter);
    }

    public void onClickToOnePlaceActivity(int id) {
        Intent intent = new Intent(this, OnePlaceActivity.class);
        intent.putExtra("EXTRA_ID", id);
        startActivity(intent);
    }

    public void onClickToAddButtonActivity(View v) {
        Intent intent = new Intent(this, AddPlaceActivity.class);
        startActivity(intent);
    }
}