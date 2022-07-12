package com.example.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private double i1 , i2 ;
    private TextView edtTextInput;
    private boolean isAdd, isSub, isMultiply, isDivide;
    private Button btnNum0,btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6,btnNum7,btnNum8,btnNum9,btnAdd,btnSub,btnMul,btnDiv,btnEqu,btnDel,btnDot, btnRemainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNum0 = findViewById(R.id.btn_no0);
        btnNum1 = findViewById(R.id.btn_no1);
        btnNum2 = findViewById(R.id.btn_no2);
        btnNum3 = findViewById(R.id.btn_no3);
        btnNum4 = findViewById(R.id.btn_no4);
        btnNum5 = findViewById(R.id.btn_no5);
        btnNum6 = findViewById(R.id.btn_no6);
        btnNum7 = findViewById(R.id.btn_no7);
        btnNum8 = findViewById(R.id.btn_no8);
        btnNum9 = findViewById(R.id.btn_no9);
        btnDot = findViewById(R.id.btn_dot);
        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btnDiv = findViewById(R.id.btn_div);
        btnRemainder = findViewById(R.id.btn_remain);
        btnDel =  findViewById(R.id.btn_del);
        btnEqu = findViewById(R.id.btn_eql);
        edtTextInput = (TextView) findViewById(R.id.edt_input);

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener( this);
        btnNum2.setOnClickListener( this);
        btnNum3.setOnClickListener( this);
        btnNum4.setOnClickListener( this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener( this);
        btnNum7.setOnClickListener( this);
        btnNum8.setOnClickListener( this);
        btnNum9.setOnClickListener( this);
        btnAdd.setOnClickListener( this);
        btnDel.setOnClickListener(this);
        btnRemainder.setOnClickListener( this);
        btnEqu.setOnClickListener( this);
        btnDiv.setOnClickListener( this);
        btnAdd.setOnClickListener(v -> {
            if (edtTextInput == null) {
                edtTextInput.setText("");
            } else {
                i1 = Float.parseFloat(edtTextInput.getText() + "");
                isAdd = true;
                edtTextInput.setText(null);
            }
        });
        btnSub.setOnClickListener(v -> {
            i1 = Float.parseFloat(edtTextInput.getText() + "");
            isSub = true;
            edtTextInput.setText(null);
        });
        btnMul.setOnClickListener(v -> {
            i1 = Float.parseFloat(edtTextInput.getText() + "");
            isMultiply = true;
            edtTextInput.setText(null);
        });
        btnDiv.setOnClickListener(v -> {
            i1 = Float.parseFloat(edtTextInput.getText() + "");
            isDivide = true;
            edtTextInput.setText(null);
        });

        btnEqu.setOnClickListener(v -> {
            i2 = Float.parseFloat(edtTextInput.getText() + "");

            if (isAdd) {
                edtTextInput.setText(i1 + i2 + "");
                isAdd = false;
            }

            if (isSub) {
                edtTextInput.setText(i1 - i2 + "");
                isSub = false;
            }

            if (isMultiply) {
                edtTextInput.setText(i1 * i2 + "");
                isMultiply = false;
            }

            if (isDivide) {
                edtTextInput.setText(i1 / i2 + "");
                isDivide = false;
            }
        });
    }
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_no0:
                edtTextInput.setText(edtTextInput.getText() + "0");
                break;

            case R.id.btn_no1:
                edtTextInput.setText(edtTextInput.getText() + "1");
                break;

            case R.id.btn_no2:
                edtTextInput.setText(edtTextInput.getText() + "2");
                break;

            case R.id.btn_no3:
                edtTextInput.setText(edtTextInput.getText() + "3");
                break;

            case R.id.btn_no4:
                edtTextInput.setText(edtTextInput.getText() + "4");
                break;

            case R.id.btn_no5:
                edtTextInput.setText(edtTextInput.getText() + "5");
                break;

            case R.id.btn_no6:
                edtTextInput.setText(edtTextInput.getText() + "6");
                break;

            case R.id.btn_no7:
                edtTextInput.setText(edtTextInput.getText() + "7");
                break;

            case R.id.btn_no8:
                edtTextInput.setText(edtTextInput.getText() + "8");
                break;

            case R.id.btn_no9:
                edtTextInput.setText(edtTextInput.getText() + "9");
                break;

            case R.id.btn_dot:
                edtTextInput.setText(edtTextInput.getText() + ".");
                break;

            case R.id.btn_del:
                edtTextInput.setText("");
                break;

            default:
        }

    }


}
