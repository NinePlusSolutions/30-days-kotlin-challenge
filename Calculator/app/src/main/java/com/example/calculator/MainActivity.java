package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_Add;
    private Button btn_Minus;
    private Button btn_Divide;
    private Button btn_Mul;
    private Button btn_Dot;
    private Button btn_Clear;
    private Button btn_Equal;

    private EditText numberEditText;

    float mValueOne, mValueTwo;

    boolean mAddition, mMinus, mMultiplication, mDivision;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_Zero);
        btn_1 = findViewById(R.id.btn_One);
        btn_2 = findViewById(R.id.btn_Two);
        btn_3 = findViewById(R.id.btn_Three);
        btn_4 = findViewById(R.id.btn_Four);
        btn_5 = findViewById(R.id.btn_Five);
        btn_6 = findViewById(R.id.btn_Six);
        btn_7 = findViewById(R.id.btn_Seven);
        btn_8 = findViewById(R.id.btn_Eight);
        btn_9 = findViewById(R.id.btn_Nine);
        btn_Dot = findViewById(R.id.btn_Dot);
        btn_Add = findViewById(R.id.btn_Add);
        btn_Minus = findViewById(R.id.btn_Minus);
        btn_Mul = findViewById(R.id.btn_Multiply);
        btn_Divide = findViewById(R.id.btn_Divide);
        btn_Clear = findViewById(R.id.btn_Clear);
        btn_Equal = findViewById(R.id.btn_Equal);
        numberEditText = findViewById(R.id.edt);

        btn_1.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "1"));

        btn_2.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "2"));

        btn_3.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "3"));

        btn_4.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "4"));

        btn_5.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "5"));

        btn_6.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "6"));

        btn_7.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "7"));

        btn_8.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "8"));

        btn_9.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "9"));

        btn_0.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "0"));

        btn_Dot.setOnClickListener(v -> numberEditText.setText(numberEditText.getText() + "."));

        btn_Add.setOnClickListener(v -> {

            if (numberEditText == null) {
                numberEditText.setText("");
            } else {
                mValueOne = Float.parseFloat(numberEditText.getText() + "");
                mAddition = true;
                numberEditText.setText(null);
            }
        });

        btn_Minus.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEditText.getText() + "");
            mMinus = true;
            numberEditText.setText(null);
        });

        btn_Mul.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEditText.getText() + "");
            mMultiplication = true;
            numberEditText.setText(null);
        });

        btn_Divide.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEditText.getText() + "");
            mDivision = true;
            numberEditText.setText(null);
        });

        btn_Equal.setOnClickListener(v -> {
            mValueTwo = Float.parseFloat(numberEditText.getText() + "");

            if (mAddition) {
                numberEditText.setText(mValueOne + mValueTwo + "");
                mAddition = false;
            }

            if (mMinus) {
                numberEditText.setText(mValueOne - mValueTwo + "");
                mMinus = false;
            }

            if (mMultiplication) {
                numberEditText.setText(mValueOne * mValueTwo + "");
                mMultiplication = false;
            }

            if (mDivision) {
                numberEditText.setText(mValueOne / mValueTwo + "");
                mDivision = false;
            }
        });

        btn_Clear.setOnClickListener(v -> numberEditText.setText(""));

    }
}