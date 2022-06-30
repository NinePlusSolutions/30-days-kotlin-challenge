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

    private EditText numberEdit;

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
        numberEdit = findViewById(R.id.edt);

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

            if (numberEdit == null) {
                numberEdit.setText("");
            } else {
                mValueOne = Float.parseFloat(numberEdit.getText() + "");
                isAddition = true;
                numberEdit.setText(null);
            }
        });

        btn_Minus.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEdit.getText() + "");
            isMinus = true;
            numberEdit.setText(null);
        });

        btn_Mul.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEdit.getText() + "");
            isMultiplication = true;
            numberEdit.setText(null);
        });

        btn_Divide.setOnClickListener(v -> {
            mValueOne = Float.parseFloat(numberEdit.getText() + "");
            isDivision = true;
            numberEdit.setText(null);
        });

        btn_Equal.setOnClickListener(v -> {
            mValueTwo = Float.parseFloat(numberEdit.getText() + "");

            if (isAddition) {
                numberEdit.setText(mValueOne + mValueTwo + "");
                isAddition = false;
            }

            if (isMinus) {
                numberEdit.setText(mValueOne - mValueTwo + "");
                isMinus = false;
            }

            if (isMultiplication) {
                numberEdit.setText(mValueOne * mValueTwo + "");
                isMultiplication = false;
            }

            if (isDivision) {
                numberEdit.setText(mValueOne / mValueTwo + "");
                isDivision = false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_Zero:
                numberEdit.setText(numberEdit.getText() + "0");
                break;

            case R.id.btn_One:
                numberEdit.setText(numberEdit.getText() + "1");
                break;

            case R.id.btn_Two:
                numberEdit.setText(numberEdit.getText() + "2");
                break;

            case R.id.btn_Three:
                numberEdit.setText(numberEdit.getText() + "3");
                break;

            case R.id.btn_Four:
                numberEdit.setText(numberEdit.getText() + "4");
                break;

            case R.id.btn_Five:
                numberEdit.setText(numberEdit.getText() + "5");
                break;

            case R.id.btn_Six:
                numberEdit.setText(numberEdit.getText() + "6");
                break;

            case R.id.btn_Seven:
                numberEdit.setText(numberEdit.getText() + "7");
                break;

            case R.id.btn_Eight:
                numberEdit.setText(numberEdit.getText() + "8");
                break;

            case R.id.btn_Nine:
                numberEdit.setText(numberEdit.getText() + "9");
                break;

            case R.id.btn_Dot:
                numberEdit.setText(numberEdit.getText() + ".");
                break;

            case R.id.btn_Clear:
                numberEdit.setText("");
                break;
        }
    }


}