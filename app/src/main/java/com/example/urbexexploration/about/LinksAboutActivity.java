package com.example.urbexexploration.about;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityLinksAboutBinding;

/**
 * Klasa widoku, zawieraącego odnośniki do stron internetowych powiązanych z tematyką urbex.
 */
public class LinksAboutActivity extends AppCompatActivity {
    private ActivityLinksAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLinksAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}