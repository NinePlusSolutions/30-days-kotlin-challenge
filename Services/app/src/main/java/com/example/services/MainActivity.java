package com.example.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtData = findViewById(R.id.edt_data_intent);
        AppCompatButton btnStartServer = findViewById(R.id.btn_start_service);
        AppCompatButton btnStopServer = findViewById(R.id.btn_stop_service);

        btnStartServer.setOnClickListener(view -> clickStartServer());
        btnStopServer.setOnClickListener(view -> clickStopServer());
    }

    private void clickStartServer() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key_data_intent", edtData.getText().toString().trim());
        startService(intent);
    }

    private void clickStopServer() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}