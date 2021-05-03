package com.example.urbexexploration.onePlace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityOnePlaceBinding;

public class OnePlaceActivity extends AppCompatActivity {
    private ActivityOnePlaceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnePlaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.onePlaceOpisTextView.setText("dasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadaskdsadnsakndjksandjsnadkjnsajkdnsjadnsajdnsakndjksandjknsajkndsjakndjksandjksandjksandjksnajdksnajkdnsajkndsjakndjsakndjksandjkasd");
        binding.onePlaceImageView1.setImageResource(R.drawable.domy);
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