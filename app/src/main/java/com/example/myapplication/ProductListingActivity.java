package com.example.myapplication;


import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductListingActivity extends AppCompatActivity {

    private Button btnBookOne;
    private Button btnBookTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);

        btnBookOne = findViewById(R.id.btnBookOne);
        btnBookTwo = findViewById(R.id.btnBookTwo);

        btnBookOne.setOnClickListener(view ->
                Toast.makeText(
                        ProductListingActivity.this,
                        "The Magic Faraway Tree added to cart",
                        Toast.LENGTH_SHORT
                ).show()
        );

        btnBookTwo.setOnClickListener(view ->
                Toast.makeText(
                        ProductListingActivity.this,
                        "Adventure of the Goblin Dog added to cart",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }
}