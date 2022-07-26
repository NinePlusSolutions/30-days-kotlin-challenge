package com.example.okhttp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGetURL = findViewById(R.id.btnGetURL);

        btnGetURL.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GetURL.class);
            startActivity(intent);
        });
    }
}