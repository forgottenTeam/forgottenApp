package com.example.urbexexploration.places;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.urbexexploration.R;
import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.databinding.RecyclerCardBinding;

/**
 * Klasa widoku pojedynczego miejsca w liście wszystkich miejsc.
 * @author Paulina Bogusz
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    private RecyclerCardBinding binding;
    private OnPlaceClickListener placeListener;

    public ItemViewHolder(@NonNull RecyclerCardBinding binding, OnPlaceClickListener placeListener) {
        super(binding.getRoot());
        this.binding = binding;
        this.placeListener = placeListener;
    }

    /**
     * Przypisanie wartości miejsca dla danego elementu z listy.
     * @param place obiekt klasy {@link Place}
     */
    public void bind(Place place) {
        Glide.with(binding.getRoot().getContext())
                .load(place.getPhotoUri())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.drawable.empty_photo)
                .placeholder(R.drawable.loading_photo)
                .centerCrop()
                .into(binding.cardImageView);
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
