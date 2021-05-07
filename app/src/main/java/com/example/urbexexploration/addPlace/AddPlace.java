package com.example.urbexexploration.addPlace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityAddBinding;

public class AddPlace extends AppCompatActivity {

    private ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         binding = ActivityAddBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

        ArrayAdapter<String> chooseCategory = new ArrayAdapter<String>(AddPlace.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.category));
        chooseCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.categoryTextView.setAdapter(chooseCategory);

        ArrayAdapter<String> chooseProvince = new ArrayAdapter<String>(AddPlace.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.province));
        chooseCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.addProvinceInputText.setAdapter(chooseProvince);


        }

    }
