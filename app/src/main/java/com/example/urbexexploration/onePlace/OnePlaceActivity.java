package com.example.urbexexploration.onePlace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityOnePlaceBinding;
import com.example.urbexexploration.places.OnPlaceClickListener;

public class OnePlaceActivity extends AppCompatActivity {
    private ActivityOnePlaceBinding binding;
    private OnePlaceViewModel onePlaceViewModel;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = getIntent().getIntExtra("EXTRA_ID", 0);
        binding = ActivityOnePlaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        onePlaceViewModel = new ViewModelProvider(this).get(OnePlaceViewModel.class);
        onePlaceViewModel.getOnePlaceLiveData().observe(this, place -> {

            latitude = place.getLatitude();
            longitude = place.getLongitude();

            binding.onePlaceOpisTextView.setText(place.getDescription());
            binding.onePlaceTitleTextView.setText(place.getName());
            binding.onePlaceCategoryTextView.setText("Kategoria: " + place.getCategory());
            binding.onePlaceCityTextView.setText("Miasto: " + place.getCity());
            binding.onePlaceProvinceTextView.setText("Województwo: " + place.getProvince());
            Glide.with(this)
                    .load(place.getPhotoUri())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .error(R.drawable.empty_photo)
                    .placeholder(R.drawable.loading_photo)
                    .centerCrop()
                    .into(binding.onePlaceImageView1);

            binding.onePlaceImageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onImageClickedExplorer(Uri.parse(place.getPhotoUri()));
                }
            });
        });
        onePlaceViewModel.loadData(id);

        binding.onePlaceButtonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("http://maps.google.com/maps?daddr=" + latitude + "," + longitude);
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }

    public void onImageClickedExplorer(Uri imageUri) {
        Intent fullScreenIntent = new Intent(this, FullScreenImageActivity.class);
        fullScreenIntent.setData(imageUri);
        startActivity(fullScreenIntent);
    }
}