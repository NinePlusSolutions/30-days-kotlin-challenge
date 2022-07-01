package com.midterm.myapplication;

import static com.midterm.myapplication.Constants.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private Button btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6,btnNum7,btnNum8,
            btnNum9,btnNum0,btnEqual,btnMulti,btnDivide,btnAdd,btnSub,btnClear,btnDot;

    private TextView tvInput,tvOutput;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '÷';
    private final char EQU = '=';
    private char ACTION;
    private double valueInput = Double.NaN;
    private double valueOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();
    }

    // ------------------------- Set up onclick button ---------------------------
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.btnNum:
                tvInput.setText(String.format("%s0", tvInput.getText()));
                break;
            case R.id.btnNum1:
                tvInput.setText(String.format("%s1", tvInput.getText()));
                break;
            case R.id.btnNum2:
                tvInput.setText(String.format("%s2", tvInput.getText()));
                break;
            case R.id.btnNum3:
                tvInput.setText(String.format("%s3", tvInput.getText()));
                break;
            case R.id.btnNum4:
                tvInput.setText(String.format("%s4", tvInput.getText()));
                break;
            case R.id.btnNum5:
                tvInput.setText(String.format("%s5", tvInput.getText()));
                break;
            case R.id.btnNum6:
                tvInput.setText(String.format("%s6", tvInput.getText()));
                break;
            case R.id.btnNum7:
                tvInput.setText(String.format("%s7", tvInput.getText()));
                break;
            case R.id.btnNum8:
                tvInput.setText(String.format("%s8", tvInput.getText()));
                break;
            case R.id.btnNum9:
                tvInput.setText(String.format("%s9", tvInput.getText()));
                break;
            case R.id.btnDot:
                tvInput.setText(String.format("%s.", tvInput.getText()));
                break;
            case R.id.btnAdd:
                try {
                    if (isInput()) {
                        addSymbol("+");
                        ACTION = ADDITION;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btnSub:
                try {
                    if (isInput()){
                        addSymbol("-");
                        ACTION = SUBTRACTION;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btnMulti:
                try {
                    if (isInput()) {
                        addSymbol("*");
                        ACTION = MULTIPLICATION;
                    }
                }   catch (Exception e) {errorHandle();}
                break;
            case R.id.btnDivide:
                try {
                    if (isInput()) {
                        addSymbol("÷");
                        ACTION = DIVISION;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btnEqual:
                try {
                    if (isInput()) {
                        if (tvInput.getText().length() > 0) {
                            doCalculator();
                        }
                        if (!isDemical()) {
                            tvOutput.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf(valueInput));
                        } else {
                            tvOutput.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf((int) valueInput));
                        }
                        tvInput.setText(null);
                        ACTION = EQU;
                    }
                } catch (Exception e) {errorHandle();}
                break;
            case R.id.btnClear:
                if (tvInput.getText().length() > 0) {
                    CharSequence name = tvInput.getText().toString();
                    tvInput.setText(name.subSequence(0, name.length() - 1));
                } else {
                    valueInput = Double.NaN;
                    valueOutput = Double.NaN;
                    tvInput.setText("");
                    tvOutput.setText("");
                }
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.btnClear:
                valueInput = Double.NaN;
                valueOutput = Double.NaN;
                tvInput.setText("");
                tvOutput.setText("");
                return true;
        }
        return false;
    }

    // ------------------------- View Setup -------------------------------
    private void viewSetup () {
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);
        btnNum0 = findViewById(R.id.btnNum0);
        btnDot = findViewById(R.id.btnDot);
        tvOutput = findViewById(R.id.tvOutput);
        tvInput = findViewById(R.id.tvInput);

        btnEqual = findViewById(R.id.btnEqual);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnClear = findViewById(R.id.btnClear);

        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnNum0.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClear.setOnLongClickListener(this);
    }

    // ------------------------- Features Function -------------------------------
    // check is decimal or not
    private boolean isDemical() {
        return valueInput == (int) valueInput;
    }

    // Check is Input or not
    private boolean isInput() {
        return !Double.isNaN(valueInput) || tvInput.getText().length() > 0;
    }

    // Add Symbol
    private void addSymbol(String symbol) {
        if (tvInput.getText().length() > 0) {
            doCalculator();
        }
        if (isDemical()) {
            tvOutput.setText(String.format((int) valueInput + "%s ", symbol));
        } else {
            tvOutput.setText(String.format(valueInput + "%s ", symbol));
        }
        tvInput.setText(null);
    }

    // Do Calculator
    private void doCalculator() {
        if (!Double.isNaN(valueInput)) {
            valueOutput = Double.parseDouble(tvInput.getText().toString()); // val 2 = text_input
            switch (ACTION) {
                case ADDITION:
                    valueInput = valueInput + valueOutput;
                    break;
                case SUBTRACTION:
                    valueInput = valueInput - valueOutput;
                    break;
                case MULTIPLICATION:
                    valueInput = valueInput * valueOutput;
                    break;
                case DIVISION:
                    valueInput = valueInput / valueOutput;
                    break;
                case EQU:
                    break;
            }
        } else {
            valueInput = Double.parseDouble(tvInput.getText().toString());
        }
        valueInput = Math.round(valueInput *100.0)/100.0;
    }

    //  Error Handle
    private void errorHandle() {
        tvOutput.setText(R.string.errorSyntax);
        tvInput.setText("");
    }
}