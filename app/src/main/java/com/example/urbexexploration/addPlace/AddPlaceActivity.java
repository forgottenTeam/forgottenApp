package com.example.urbexexploration.addPlace;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.urbexexploration.R;
import com.example.urbexexploration.data.Place;
import com.example.urbexexploration.data.PlacesRepository;
import com.example.urbexexploration.databinding.ActivityAddBinding;
import com.example.urbexexploration.upload.UriRequestBody;

public class AddPlaceActivity extends AppCompatActivity {

    private PlacesRepository placesRepository = new PlacesRepository();
    private ActivityAddBinding binding;
    public static final int PICK_IMAGE_REQUEST = 1;
    private AddPlaceViewModel addPlaceViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addPlaceViewModel = new ViewModelProvider(this).get(AddPlaceViewModel.class);

        binding.addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isNotValid()) {
                    Toast.makeText(AddPlaceActivity.this, "Uzupełnij wszystkie pola!", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.parse(addPlaceViewModel.getUriImage());
                    addPlaceViewModel.addNewPlace(
                            new UriRequestBody(getContentResolver(), uri),
                            getFileName(uri),
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
            addPlaceViewModel.saveUri(data.getData().toString());
            Glide.with(this)
                    .load(data.getData())
                    .centerCrop()
                    .into(binding.previewImageView);
        }
    }

    private Boolean isNotValid() {
        return TextUtils.isEmpty(binding.categoryTextView.getText()) ||
                TextUtils.isEmpty(binding.addNameInputText.getText()) ||
                TextUtils.isEmpty(binding.addCityInputText.getText()) ||
                TextUtils.isEmpty(binding.addDescriptionInputText.getText()) ||
                TextUtils.isEmpty(binding.addProvinceInputText.getText()) ||
                TextUtils.isEmpty(binding.addLatitudeInputText.getText()) ||
                TextUtils.isEmpty(binding.addLongitudeInputText.getText()) ||
                TextUtils.isEmpty(addPlaceViewModel.getUriImage());
    }

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}
