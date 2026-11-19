package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OneActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_one);
        btn = findViewById(R.id.btnClick);
        btn.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View view){
            Intent i = new Intent(OneActivity.this, TwoActivity.class);
            //passing the data to second activity
            i.putExtra("id", 001);
            i.putExtra("name","Dhamra");
            i.putExtra("address", "Kathmandu");
            startActivity(i);
        }
        });

    }
}