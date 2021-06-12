package com.example.urbexexploration.about;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbexexploration.databinding.ActivityLinksAboutBinding;

/**
 * Klasa widoku, zawierającego odnośniki do stron internetowych powiązanych z tematyką urbex.
 * @author Paulina Bogusz
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