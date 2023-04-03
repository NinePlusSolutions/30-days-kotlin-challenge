package com.example.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("Activity Lifecycle","onCreate");
        Toast.makeText(this, "Activity Lifecycle: onCreate", Toast.LENGTH_SHORT).show();

    }
    protected void onStart(){
        super.onStart();
        Log.d("Activity Lifecycle","onStart");
        Toast.makeText(this,"Activity Lifecycle: onStart",Toast.LENGTH_SHORT).show();
    }
    protected void onPause(){
        super.onPause();
        Log.d("Activity Lifecycle","onPause");
        Toast.makeText(this,"Activity Lifecycle: onPause",Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Activity Lifrcycle","onDestroy");
        Toast.makeText(this, "Activity Lifecycle: onDestroy", Toast.LENGTH_SHORT).show();
    }
}