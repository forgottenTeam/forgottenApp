package com.example.urbexexploration.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.urbexexploration.databinding.ActivityMainBinding;
import com.example.urbexexploration.places.RecyclerViewActivity;
import com.example.urbexexploration.about.AboutActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainButtonDomy.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonMilitaria.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonZamki.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonPrzemyslowe.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonKolejowe.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonUslugowe.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonInfrastrukturalne.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonKoscioly.setOnClickListener(v -> goToRecyclerActivity(v));
        binding.mainButtonInne.setOnClickListener(v -> goToRecyclerActivity(v));

        binding.mainButtonAbout.setOnClickListener(v -> goToAboutActivity(v));
    }

    public void goToAboutActivity(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void goToRecyclerActivity(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }


}