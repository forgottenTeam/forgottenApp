package com.example.urbexexploration.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityAboutBinding;

/**
 * Klasa głównego widoku "About", zawierającego ogólne informacje na temat urbex.
 */
public class AboutActivity extends AppCompatActivity {
    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.aboutTitleTextView.setText(R.string.about_urbex_title);
        binding.aboutTitle2TextView.setText(R.string.about_urbex);
        binding.aboutDlaKogoTextView.setText(R.string.for_who_title);
        binding.aboutDlaKogo2TextView.setText(R.string.for_who);
        binding.aboutJakZaczacTextView.setText(R.string.how_start_title);
        binding.aboutJakZaczac2TextView.setText(R.string.how_start);
        binding.aboutPrawoTextView.setText(R.string.urbex_law_title);
        binding.aboutPrawo2TextView.setText(R.string.urbex_law);
        binding.aboutButtonLinks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            goToLinksAboutActivity(v);
            }
        });
    }

    /**
     * Przejście do widoku, zawierającego odnośniki do stron internetowych powiązanych z tematyką urbex.
     */
    public void goToLinksAboutActivity(View view) {
        Intent intent = new Intent(this, LinksAboutActivity.class);
        startActivity(intent);
    }


}