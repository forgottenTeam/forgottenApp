package com.example.urbexexploration.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbexexploration.R;
import com.example.urbexexploration.about.AboutActivity;
import com.example.urbexexploration.databinding.ActivityMainBinding;
import com.example.urbexexploration.places.PlaceListActivity;
import com.example.urbexexploration.search.SearchActivity;

/**
 * Klasa widoku głównego aplikacji.
 * @author Paulina Bogusz
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainButtonDomy.setOnClickListener(v -> goToPlaceActivity("Mieszkalne"));
        binding.mainButtonMilitaria.setOnClickListener(v -> goToPlaceActivity("Militarne"));
        binding.mainButtonZamki.setOnClickListener(v -> goToPlaceActivity("Zamki"));
        binding.mainButtonPrzemyslowe.setOnClickListener(v -> goToPlaceActivity("Przemysłowe"));
        binding.mainButtonKolejowe.setOnClickListener(v -> goToPlaceActivity("Kolejowe"));
        binding.mainButtonUslugowe.setOnClickListener(v -> goToPlaceActivity("Usługowe"));
        binding.mainButtonInfrastrukturalne.setOnClickListener(v -> goToPlaceActivity("Infrastrukturalne"));
        binding.mainButtonKoscioly.setOnClickListener(v -> goToPlaceActivity("Sakralne"));
        binding.mainButtonInne.setOnClickListener(v -> goToPlaceActivity("Inne"));
        setupBottomNavigationView();
    }

    /**
     * Przejście do widoku "About", zawierającego ogólne informacje na temat urbex.
     */
    public void goToAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    /**
     * Przejście do widoku listy obiektów z wybranej kategorii
     * @param category wybrana kategoria
     */
    public void goToPlaceActivity(String category) {
        Intent intent = new Intent(this, PlaceListActivity.class);
        intent.putExtra("EXTRA_CATEGORY", category);
        startActivity(intent);
    }

    /**
     * Przejście do widoku, w którym użytkownik może wyszukać listę miejsc z wybranego województwa
     */
    public void goToSearchActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    /**
     * Inicjalizacja dolnego menu aplikacji w widoku głównym
     */
    private void setupBottomNavigationView() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_search:
                    goToSearchActivity();
                    break;
                case R.id.page_list:
                    goToPlaceActivity(null);
                    break;
                case R.id.page_info:
                    goToAboutActivity();
                    break;
            }
            return true;
        });
    }

}