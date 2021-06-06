package com.example.urbexexploration.onePlace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityFullScreenImageBinding;

public class FullScreenImageActivity extends AppCompatActivity {
private ActivityFullScreenImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullScreenImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent callingActivityIntent = getIntent();
        if(callingActivityIntent != null) {
            Uri imageUri = callingActivityIntent.getData();
            if(imageUri != null) {

                Glide.with(this)
                        .load(imageUri)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(binding.fullScreenImageView);
            }
        }
    }
}