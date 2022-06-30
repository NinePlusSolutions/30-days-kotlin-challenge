package com.ngockhanh.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private TextView tvResult;
   private String op= "";
   private String oldNumber="";
   private Boolean newOperation = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
    }
    public void numberEvent(View view) {
        if(newOperation){
            tvResult.setText("");
        }
        newOperation = false;
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
            case R.id.btnDot:
                number += ".";
                break;
        }
        tvResult.setText(number);
    }

    public void clearnEvent(View view) {
        tvResult.setText("");
    }

    public void operatorEvent(View view) {
        newOperation = true;
        oldNumber = tvResult.getText().toString();
        switch (view.getId()){
            case R.id.btnDivide:
                op = "/";
                break;
            case R.id.btnMultiply:
                op = "*";
                break;
            case R.id.btnSubtract:
                op = "-";
                break;
            case R.id.btnPlus:
                op = "+";
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void resultEvent(View view) {
        String newNumber = tvResult.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        tvResult.setText(result+"");
    }
}
