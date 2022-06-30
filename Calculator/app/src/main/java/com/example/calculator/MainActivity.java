package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // this line is a comment the warning issue, when it fixed, I will remove
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNum0 = findViewById(R.id.btnNum0);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);
        btnDot = findViewById(R.id.btnDot);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);
        btnEqual = findViewById(R.id.btnEqual);
        numberEdit = findViewById(R.id.edt);

        this.setListener();

        btnAdd.setOnClickListener(v -> {

            if (numberEdit == null) {

                numberEdit.setText("");
            } else {
                valueOne = Float.parseFloat(numberEdit.getText() + "");
                isAddition = true;
                numberEdit.setText(null);
            }
        });

        btnMinus.setOnClickListener(v -> {
            valueOne = Float.parseFloat(numberEdit.getText() + "");
            isMinus = true;
            numberEdit.setText(null);
        });

        btnMul.setOnClickListener(v -> {
            valueOne = Float.parseFloat(numberEdit.getText() + "");
            isMultiplication = true;
            numberEdit.setText(null);
        });

        btnDivide.setOnClickListener(v -> {
            valueOne = Float.parseFloat(numberEdit.getText() + "");
            isDivision = true;
            numberEdit.setText(null);
        });

        btnEqual.setOnClickListener(v -> {
            valueTwo = Float.parseFloat(numberEdit.getText() + "");

            if (isAddition) {
                numberEdit.setText(valueOne + valueTwo + "");
                isAddition = false;
            }

            if (isMinus) {
                numberEdit.setText(valueOne - valueTwo + "");
                isMinus = false;
            }

            if (isMultiplication) {
                numberEdit.setText(valueOne * valueTwo + "");
                isMultiplication = false;
            }

            if (isDivision) {
                numberEdit.setText(valueOne / valueTwo + "");
                isDivision = false;
            }
        });
    }

    // this line is a comment the warning issue, when it fixed, I will remove
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnNum0:
                numberEdit.setText(String.format("%s 0", numberEdit.getText()));
                break;

            case R.id.btnNum1:
                numberEdit.setText(numberEdit.getText() + "1");
                break;

            case R.id.btnNum2:
                numberEdit.setText(numberEdit.getText() + "2");
                break;

            case R.id.btnNum3:
                numberEdit.setText(numberEdit.getText() + "3");
                break;

            case R.id.btnNum4:
                numberEdit.setText(numberEdit.getText() + "4");
                break;

            case R.id.btnNum5:
                numberEdit.setText(numberEdit.getText() + "5");
                break;

            case R.id.btnNum6:
                numberEdit.setText(numberEdit.getText() + "6");
                break;

            case R.id.btnNum7:
                numberEdit.setText(numberEdit.getText() + "7");
                break;

            case R.id.btnNum8:
                numberEdit.setText(numberEdit.getText() + "8");
                break;

            case R.id.btnNum9:
                numberEdit.setText(numberEdit.getText() + "9");
                break;

            case R.id.btnDot:
                numberEdit.setText(numberEdit.getText() + ".");
                break;

            case R.id.btnClear:
                numberEdit.setText("");
                break;

            default:
                break;
        }
    }

    private Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7,
            btnNum8, btnNum9, btnAdd, btnMinus, btnDivide, btnMul, btnDot, btnClear, btnEqual;

    private EditText numberEdit;

    private float valueOne, valueTwo;

    private boolean isAddition, isMinus, isMultiplication, isDivision;


    private void setListener() {
        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }
}