package com.example.urbexexploration.places;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.databinding.RecyclerCardBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<Place> mRecyclerList;
    private OnPlaceClickListener placeListener;

    public RecycleAdapter(OnPlaceClickListener placeListener) {
        this.placeListener = placeListener;
        mRecyclerList = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerCardBinding recyclerCardBinding = RecyclerCardBinding
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                );
        ItemViewHolder ivh = new ItemViewHolder(recyclerCardBinding, placeListener);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(mRecyclerList.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecyclerList.size();
    }

    public void submitList(List<Place> list) {
        mRecyclerList = list;
        notifyDataSetChanged();
    }

}
