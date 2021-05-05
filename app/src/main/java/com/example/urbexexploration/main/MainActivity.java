package com.example.urbexexploration.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.urbexexploration.databinding.ActivityMainBinding;
import com.example.urbexexploration.places.PlaceListActivity;
import com.example.urbexexploration.about.AboutActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainButtonDomy.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonMilitaria.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonZamki.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonPrzemyslowe.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonKolejowe.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonUslugowe.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonInfrastrukturalne.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonKoscioly.setOnClickListener(v -> goToPlaceActivity(v));
        binding.mainButtonInne.setOnClickListener(v -> goToPlaceActivity(v));

        binding.mainButtonAbout.setOnClickListener(v -> goToAboutActivity(v));
    }

    public void goToAboutActivity(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void goToPlaceActivity(View view) {
        Intent intent = new Intent(this, PlaceListActivity.class);
        startActivity(intent);
    }


}