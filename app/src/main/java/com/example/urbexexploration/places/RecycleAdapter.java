package com.example.urbexexploration.places;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbexexploration.R;
import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.databinding.RecyclerCardBinding;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ItemViewHolder> {
    private ArrayList<CardItem> mRecyclerList;


    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private RecyclerCardBinding binding;

        public ItemViewHolder(@NonNull RecyclerCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Place place) {
            binding.cardImageView.setImageResource(R.drawable.domy);
            binding.cardCategoryTextView.setText(place.getCategory());
            binding.cardLocalisationTextView.setText(place.getLocalization());
            binding.cardNameTextView.setText(place.getName());
        }
    }


    public RecycleAdapter(ArrayList<CardItem> recycleList) {
        mRecyclerList = recycleList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //   View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card, parent, false);
        RecyclerCardBinding recyclerCardBinding = RecyclerCardBinding
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                );
        ItemViewHolder ivh = new ItemViewHolder(recyclerCardBinding);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        CardItem currentItem = mRecyclerList.get(position);
        holder.bind(new Place());
    }

    @Override
    public int getItemCount() {
        return mRecyclerList.size();
    }

    public void filterList(ArrayList<CardItem> filteredList) {
        mRecyclerList = filteredList;
        notifyDataSetChanged();
    }

}
