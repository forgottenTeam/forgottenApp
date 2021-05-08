package com.example.urbexexploration.onePlace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityOnePlaceBinding;
import com.example.urbexexploration.places.OnPlaceClickListener;

public class OnePlaceActivity extends AppCompatActivity {
    private ActivityOnePlaceBinding binding;
    private OnePlaceViewModel onePlaceViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = getIntent().getIntExtra("EXTRA_ID", 0);
        binding = ActivityOnePlaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        onePlaceViewModel = new ViewModelProvider(this).get(OnePlaceViewModel.class);
        onePlaceViewModel.getOnePlaceLiveData().observe(this, place -> {
            binding.onePlaceOpisTextView.setText(place.getDescription());
            binding.onePlaceTitleTextView.setText(place.getName());
            binding.onePlaceCategoryTextView.setText("Kategoria: " + place.getCategory());
            binding.onePlaceCityTextView.setText("Miasto: " + place.getCity());
            binding.onePlaceProvinceTextView.setText("Województwo: " + place.getProvince());
            binding.onePlaceImageView1.setImageResource(R.drawable.domy);
        });
        onePlaceViewModel.loadData(id);


        binding.onePlaceImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickedExplorer(Uri.parse("https://buydesign.pl/wp-content/uploads/2019/01/obrazek-mi%C5%9B-koala-32320-min.png"));
            }
        });
        binding.onePlaceImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickedExplorer(Uri.parse("https://buydesign.pl/wp-content/uploads/2019/01/obrazek-mi%C5%9B-koala-32320-min.png"));
            }
        });
        binding.onePlaceImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickedExplorer(Uri.parse("https://buydesign.pl/wp-content/uploads/2019/01/obrazek-mi%C5%9B-koala-32320-min.png"));
            }
        });
        binding.onePlaceImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickedExplorer(Uri.parse("https://buydesign.pl/wp-content/uploads/2019/01/obrazek-mi%C5%9B-koala-32320-min.png"));
            }
        });
    }

    public void onImageClickedExplorer(Uri imageUri) {
        Intent fullScreenIntent = new Intent(this, FullScreenImageActivity.class);
        fullScreenIntent.setData(imageUri);
        startActivity(fullScreenIntent);
    }
}