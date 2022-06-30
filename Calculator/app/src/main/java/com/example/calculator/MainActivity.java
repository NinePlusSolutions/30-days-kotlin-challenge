package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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

    private float mValueOne, mValueTwo;

    private boolean isAddition, isMinus, isMultiplication, isDivision;

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

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_Dot.setOnClickListener(this);
        btn_Clear.setOnClickListener(this);

        btn_Add.setOnClickListener(v -> {

            if (numberEditText == null) {
                numberEditText.setText("");
            } else {
                mValueOne = Float.parseFloat(numberEditText.getText() + "");
                isAddition = true;
                numberEditText.setText(null);
            }
        });

        btn_Minus.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEditText.getText() + "");
            isMinus = true;
            numberEditText.setText(null);
        });

        btn_Mul.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEditText.getText() + "");
            isMultiplication = true;
            numberEditText.setText(null);
        });

        btn_Divide.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEditText.getText() + "");
            isDivision = true;
            numberEditText.setText(null);
        });

        btn_Equal.setOnClickListener(v -> {
            mValueTwo = Float.parseFloat(numberEditText.getText() + "");

            if (isAddition) {
                numberEditText.setText(mValueOne + mValueTwo + "");
                isAddition = false;
            }

            if (isMinus) {
                numberEditText.setText(mValueOne - mValueTwo + "");
                isMinus = false;
            }

            if (isMultiplication) {
                numberEditText.setText(mValueOne * mValueTwo + "");
                isMultiplication = false;
            }

            if (isDivision) {
                numberEditText.setText(mValueOne / mValueTwo + "");
                isDivision = false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_Zero:
                numberEditText.setText(numberEditText.getText() + "0");
                break;

            case R.id.btn_One:
                numberEditText.setText(numberEditText.getText() + "1");
                break;

            case R.id.btn_Two:
                numberEditText.setText(numberEditText.getText() + "2");
                break;

            case R.id.btn_Three:
                numberEditText.setText(numberEditText.getText() + "3");
                break;

            case R.id.btn_Four:
                numberEditText.setText(numberEditText.getText() + "4");
                break;

            case R.id.btn_Five:
                numberEditText.setText(numberEditText.getText() + "5");
                break;

            case R.id.btn_Six:
                numberEditText.setText(numberEditText.getText() + "6");
                break;

            case R.id.btn_Seven:
                numberEditText.setText(numberEditText.getText() + "7");
                break;

            case R.id.btn_Eight:
                numberEditText.setText(numberEditText.getText() + "8");
                break;

            case R.id.btn_Nine:
                numberEditText.setText(numberEditText.getText() + "9");
                break;

            case R.id.btn_Dot:
                numberEditText.setText(numberEditText.getText() + ".");
                break;

            case R.id.btn_Clear:
                numberEditText.setText("");
                break;
        }
    }


}