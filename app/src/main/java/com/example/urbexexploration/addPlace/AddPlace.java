package com.example.urbexexploration.addPlace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.urbexexploration.databinding.ActivityAddBinding;

public class AddPlace extends AppCompatActivity {

    private ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         binding = ActivityAddBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

        // Get input text
//        String input1 = binding.addNameInputText.getText().toString();
//        binding.addNameInputText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

       // val inputText = outlinedTextField.editText?.text.toString()

//        outlinedTextField.editText?.doOnTextChanged { inputText, _, _, _ ->
//            // Respond to input text change
        }

    }
