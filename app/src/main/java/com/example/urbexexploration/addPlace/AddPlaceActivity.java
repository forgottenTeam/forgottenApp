package com.example.urbexexploration.addPlace;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.urbexexploration.R;
import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;
import com.example.urbexexploration.databinding.ActivityAddBinding;
import com.example.urbexexploration.upload.UriRequestBody;

public class AddPlaceActivity extends AppCompatActivity {

    private PlacesRepository placesRepository = new PlacesRepository();
    private ActivityAddBinding binding;
    public static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        ArrayAdapter<String> chooseCategory = new ArrayAdapter<String>(AddPlaceActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.category));
        chooseCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.categoryTextView.setAdapter(chooseCategory);

        ArrayAdapter<String> chooseProvince = new ArrayAdapter<String>(AddPlaceActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.province));
        chooseCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.addProvinceInputText.setAdapter(chooseProvince);

        placesRepository.getUploadResultLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(AddPlaceActivity.this, s, Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            placesRepository.upload(
                    new UriRequestBody(getContentResolver(), data.getData()),
                    new Place(0, binding.addNameInputText.getText().toString(),
                            binding.categoryTextView.getText().toString(),
                            binding.addCityInputText.getText().toString(),
                            binding.addDescriptionInputText.getText().toString(),
                            binding.addProvinceInputText.getText().toString(),
                            Double.valueOf(binding.addLatitudeInputText.getText().toString()),
                            Double.valueOf(binding.addLongitudeInputText.getText().toString()),
                            null
                    )
            );
        }
    }

}
