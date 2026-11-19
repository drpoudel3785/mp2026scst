package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // Use the ID of your TextView in activity_two.xml
        TextView txtDetails = findViewById(R.id.txtResult);

        Intent i = getIntent();

        int id = i.getIntExtra("id", 0);
        String name = i.getStringExtra("name");
        String address = i.getStringExtra("address");

        txtDetails.setText(
                "ID: " + id + "\nName: " + name +
                        "\nAddress: " + address
        );
    }
}