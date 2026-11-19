package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
        Intent i =getIntent();
        int id=i.getIntExtra("id", 0);
        String name=i.getStringExtra("name");
        String address = i.getStringExtra("address");
        TextView txt=findViewById(R.id.txtResult);
        txt.setText("ID="+id+"\n"+"Name="+name+"\n"+"Address="+address+"\n");

    }
}