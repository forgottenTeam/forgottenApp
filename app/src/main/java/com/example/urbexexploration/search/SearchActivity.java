package com.example.urbexexploration.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivitySearchBinding;
import com.example.urbexexploration.places.PlaceListActivity;

/**
 * Klasa widoku search - filtrowanie listy wg wybranego województwa
 */
public class SearchActivity extends AppCompatActivity {
    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView imageView;
    private ActivitySearchBinding binding;
    private String province;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        binding.searchImageView.setImageResource(R.drawable.mapa_wojewodztwa);
        imageView = binding.searchImageView;

        ArrayAdapter<String> chooseProvince = new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.province));
        chooseProvince.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.searchProvinceInputText.setAdapter(chooseProvince);
        binding.searchSearchButton.setOnClickListener(v -> goToPlaceActivityProvince(binding.searchProvinceInputText.getText().toString()));

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    /**
     * Skalowanie obrazka mapy Polski za pomocą gestu
     */
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);
            return true;
        }
    }

    /**
     * Przejście do widoku listy miejsc, przefiltrowanych wg wybranego województwa
     * @param province wybrane przez użytkowanika województwo, wg którego zostanie przefiltrowana lista
     */
    public void goToPlaceActivityProvince(String province) {
        Intent intent = new Intent(this, PlaceListActivity.class);
        intent.putExtra("EXTRA_PROVINCE", province);
        startActivity(intent);
    }
}