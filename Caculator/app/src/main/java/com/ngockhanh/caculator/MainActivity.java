package com.ngockhanh.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Boolean newOperation = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);

    }

    public void numberEvent(View view) {
        String number = tvResult.getText().toString();
        switch (view.getId()){
            case R.id.btnOne:
                number += "1";
                break;
            case R.id.btnTwo:
                number += "2";
                break;
            case R.id.btnThree:
                number += "3";
                break;
            case R.id.btnFour:
                number += "4";
                break;
            case R.id.btnFive:
                number += "5";
                break;
            case R.id.btnSix:
                number += "6";
                break;
            case R.id.btnSeven:
                number += "7";
                break;
            case R.id.btnEight:
                number += "8";
                break;
            case R.id.btnNine:
                number += "9";
                break;
            case R.id.btnZero:
                number += "0";
                break;
        }
        tvResult.setText(number);
    }

    public void clearnEvent(View view) {
        tvResult.setText("");
    }
}