package com.midterm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_0;
    private Button btn_equal;
    private Button btn_multi;
    private Button btn_divide;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_clear;
    private Button btn_dot;

    private TextView tv_input;
    private TextView tv_output;


//     không thể thay đổi giá trị của biến final (nó sẽ là hằng số).
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '÷';
    private final char EQU = '=';
    private char ACTION;


    // val 1 : old value
    // val 2 : input value
    private double val1 = Double.NaN;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();
    }

    // ------------------------- Set up onclick button ---------------------------
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.btn_0:
                tv_input.setText(tv_input.getText().toString() + "0");
                break;
            case R.id.btn_1:
                tv_input.setText(tv_input.getText().toString() + "1");
                break;
            case R.id.btn_2:
                tv_input.setText(tv_input.getText().toString() + "2");
                break;
            case R.id.btn_3:
                tv_input.setText(tv_input.getText().toString() + "3");
                break;
            case R.id.btn_4:
                tv_input.setText(tv_input.getText().toString() + "4");
                break;
            case R.id.btn_5:
                tv_input.setText(tv_input.getText().toString() + "5");
                break;
            case R.id.btn_6:
                tv_input.setText(tv_input.getText().toString() + "6");
                break;
            case R.id.btn_7:
                tv_input.setText(tv_input.getText().toString() + "7");
                break;
            case R.id.btn_8:
                tv_input.setText(tv_input.getText().toString() + "8");
                break;
            case R.id.btn_9:
                tv_input.setText(tv_input.getText().toString() + "9");
                break;
            case R.id.btn_dot:
                tv_input.setText(tv_input.getText().toString() + ".");
                break;
            case R.id.btn_add:
                try {
                    if (isInput()) {
                        addSymbol("+");
                        ACTION = ADDITION;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btn_sub:
                try {
                    if (isInput()){
                        addSymbol("-");
                        ACTION = SUBTRACTION;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btn_multi:
                try {
                    if (isInput()) {
                        addSymbol("*");
                        ACTION = MULTIPLICATION;
                    }
                }   catch (Exception e) {errorHandle();}
                break;
            case R.id.btn_divide:
                try {
                    if (isInput()) {
                        addSymbol("÷");
                        ACTION = DIVISION;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btn_equal:
                try {
                    if (isInput()) {
                        if (tv_input.getText().length() > 0) {
                            operation();
                        }
                        if (!ifReallyDecimal()) {
                            tv_output.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf(val1));
                        } else {
                            tv_output.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf((int) val1));
                        }
                        tv_input.setText(null);
                        ACTION = EQU;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btn_clear:
                if (tv_input.getText().length() > 0) {
                    CharSequence name = tv_input.getText().toString();
                    tv_input.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    tv_input.setText("");
                    tv_output.setText("");
                }
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.btn_clear:
                val1 = Double.NaN;
                val2 = Double.NaN;
                tv_input.setText("");
                tv_output.setText("");
                return true;
        }
        return false;
    }

    // ------------------------- View Setup -------------------------------
    private void viewSetup () {
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        btn_dot = findViewById(R.id.btn_dot);
        tv_output = findViewById(R.id.tv_output);
        tv_input = findViewById(R.id.tv_input);

        btn_equal = findViewById(R.id.btn_equal);
        btn_multi = findViewById(R.id.btn_multi);
        btn_divide = findViewById(R.id.btn_divide);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_clear = findViewById(R.id.btn_clear);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_clear.setOnLongClickListener(this);
    }

    // ------------------------- Features Function -------------------------------
    // kiem tra so thap phan
    private boolean ifReallyDecimal() {
        return val1 == (int) val1;
    }

    // kiem tra nhap so hay chua
    private boolean isInput() {
        if ( !Double.isNaN(val1) || tv_input.getText().length() > 0 ){
            return true;
        }
        return false;
    }

    // them dau
    private void addSymbol(String symbol) {
        if (tv_input.getText().length() > 0) {
            operation();
        }
        if (ifReallyDecimal()) {
            tv_output.setText((int) val1 + " " + symbol);
        } else {
            tv_output.setText(val1 + " " + symbol);
        }
        tv_input.setText(null);
    }

    // toan tu
    private void operation() {
        if (!Double.isNaN(val1)) { // kiem tra val1 null hay khong
            val2 = Double.parseDouble(tv_input.getText().toString()); // gan val 2 = text_input
            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            // null thi gan bang gia tri input
            val1 = Double.parseDouble(tv_input.getText().toString());
        }
        val1 = Math.round(val1*100.0)/100.0;
    }

    //  Error Handle
    private void errorHandle() {
        tv_output.setText("Error Syntax");
        tv_input.setText("");
    }
}