package com.example.urbexexploration.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.urbexexploration.data.Place;
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

        binding.mainButtonDomy.setOnClickListener(v -> goToPlaceActivity(v, "Mieszkalne"));
        binding.mainButtonMilitaria.setOnClickListener(v -> goToPlaceActivity(v, "Militarne"));
        binding.mainButtonZamki.setOnClickListener(v -> goToPlaceActivity(v, "Zamki"));
        binding.mainButtonPrzemyslowe.setOnClickListener(v -> goToPlaceActivity(v, "Przemysłowe"));
        binding.mainButtonKolejowe.setOnClickListener(v -> goToPlaceActivity(v, "Kolejowe"));
        binding.mainButtonUslugowe.setOnClickListener(v -> goToPlaceActivity(v, "Usługowe"));
        binding.mainButtonInfrastrukturalne.setOnClickListener(v -> goToPlaceActivity(v, "Infrastrukturalne"));
        binding.mainButtonKoscioly.setOnClickListener(v -> goToPlaceActivity(v, "Sakralne"));
        binding.mainButtonInne.setOnClickListener(v -> goToPlaceActivity(v, "Inne"));
        binding.mainButtonAbout.setOnClickListener(v -> goToAboutActivity(v));
        binding.mainButtonList.setOnClickListener(v -> goToPlaceActivity(v, null));
    }

    public void goToAboutActivity(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void goToPlaceActivity(View view, String category) {
        Intent intent = new Intent(this, PlaceListActivity.class);
        intent.putExtra("EXTRA_CATEGORY", category);
        startActivity(intent);
    }


}