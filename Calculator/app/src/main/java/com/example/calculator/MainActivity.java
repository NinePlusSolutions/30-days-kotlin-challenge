package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     Button btn_0,  btn_1,  btn_2,  btn_3,  btn_4,  btn_5,  btn_6,
             btn_7,  btn_8,  btn_9,  btn_Add,  btn_Minus,  btn_Divide,
             btn_Mul,  btn_Dot,  btn_Clear,  btn_Equal;

    EditText numberEditText;

    float mValueOne, mValueTwo;

    boolean mAddition, mMinus, mMultiplication, mDivision;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn_0 = (Button) findViewById(R.id.btn_Zero);
        btn_1 = (Button) findViewById(R.id.btn_One);
        btn_2 = (Button) findViewById(R.id.btn_Two);
        btn_3 = (Button) findViewById(R.id.btn_Three);
        btn_4 = (Button) findViewById(R.id.btn_Four);
        btn_5 = (Button) findViewById(R.id.btn_Five);
        btn_6 = (Button) findViewById(R.id.btn_Six);
        btn_7 = (Button) findViewById(R.id.btn_Seven);
        btn_8 = (Button) findViewById(R.id.btn_Eight);
        btn_9 = (Button) findViewById(R.id.btn_Nine);
        btn_Dot = (Button) findViewById(R.id.btn_Dot);
        btn_Add = (Button) findViewById(R.id.btn_Add);
        btn_Minus = (Button) findViewById(R.id.btn_Minus);
        btn_Mul = (Button) findViewById(R.id.btn_Multiply);
        btn_Divide = (Button) findViewById(R.id.btn_Divide);
        btn_Clear = (Button) findViewById(R.id.btn_Clear);
        btn_Equal = (Button) findViewById(R.id.btn_Equal);
        numberEditText = (EditText) findViewById(R.id.edt);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "9");
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + "0");
            }
        });

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numberEditText == null) {
                    numberEditText.setText("");
                } else {
                    mValueOne = Float.parseFloat(numberEditText.getText() + "");
                    mAddition = true;
                    numberEditText.setText(null);
                }
            }
        });

        btn_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(numberEditText.getText() + "");
                mMinus = true;
                numberEditText.setText(null);
            }
        });

        btn_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(numberEditText.getText() + "");
                mMultiplication = true;
                numberEditText.setText(null);
            }
        });

        btn_Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(numberEditText.getText() + "");
                mDivision = true;
                numberEditText.setText(null);
            }
        });

        btn_Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(numberEditText.getText() + "");

                if (mAddition == true) {
                    numberEditText.setText(mValueOne + mValueTwo + "");
                    mAddition = false;
                }

                if (mMinus == true) {
                    numberEditText.setText(mValueOne - mValueTwo + "");
                    mMinus = false;
                }

                if (mMultiplication == true) {
                    numberEditText.setText(mValueOne * mValueTwo + "");
                    mMultiplication = false;
                }

                if (mDivision == true) {
                    numberEditText.setText(mValueOne / mValueTwo + "");
                    mDivision = false;
                }
            }
        });

        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText("");
            }
        });

        btn_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEditText.setText(numberEditText.getText() + ".");
            }
        });
    }
}

