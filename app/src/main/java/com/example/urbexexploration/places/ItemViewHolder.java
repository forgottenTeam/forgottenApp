package com.example.urbexexploration.places;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbexexploration.R;
import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.databinding.RecyclerCardBinding;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private RecyclerCardBinding binding;
    private OnPlaceClickListener placeListener;

    public ItemViewHolder(@NonNull RecyclerCardBinding binding, OnPlaceClickListener placeListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.placeListener = placeListener;
    }

    public void bind(Place place) {
        binding.cardImageView.setImageResource(R.drawable.domy);
        binding.cardCategoryTextView.setText(place.getCategory());
        binding.cardLocalisationTextView.setText(place.getProvince());
        binding.cardNameTextView.setText(place.getName());
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeListener.onPlaceClick(place.getId());
            }
        });
    }
}
