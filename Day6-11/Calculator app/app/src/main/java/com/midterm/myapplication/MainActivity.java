package com.midterm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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


        // --------------------------- Set up Onclick Number -------------------------------------
        viewSetup();
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "1");
            }
        });
//
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "9");
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + "0");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_input.setText(tv_input.getText().toString() + ".");
            }
        });



        // --------------------------- Operation Click -------------------------------------
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (isInput()) {
                        if (tv_input.getText().length() > 0) { // neu textInput > 0 thi tinh
                            operation();
                        }
                        if (!ifReallyDecimal()) {
                            tv_output.setText(val1 + " +");
                        } else {
                            tv_output.setText((int) val1 + " +");
                        }
                        tv_input.setText(null);
                        ACTION = ADDITION;
                    }
                } catch (Exception e) {
                    tv_output.setText("Error Syntax");
                    tv_input.setText("");
                }
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (isInput()){
                        if (tv_input.getText().length() > 0) {
                            operation();
                        }
                        if (!ifReallyDecimal()) {
                            tv_output.setText(val1 + " -");
                        } else {
                            tv_output.setText((int) val1 + " -");
                        }
                        tv_input.setText(null);
                        ACTION = SUBTRACTION;
                    }
                } catch (Exception e) {
                    tv_output.setText("Error Syntax");
                    tv_input.setText("");
                }
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                try {
                    if (isInput()) {
                        if (tv_input.getText().length() > 0) {
                            operation();
                        }
                        if (!ifReallyDecimal()) {
                            tv_output.setText(val1 + " ×");
                        } else {
                            tv_output.setText((int) val1 + " ×");
                        }
                        tv_input.setText(null);
                        ACTION = MULTIPLICATION;
                    }
                }   catch (Exception e) {
                    tv_output.setText("Error Syntax");
                    tv_input.setText("");
                }
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (isInput()) {
                        if (tv_input.getText().length() > 0) {
                            operation();
                        }
                        if (ifReallyDecimal()) {
                            tv_output.setText((int) val1 + " ÷");
                        } else {
                            tv_output.setText(val1 + " ÷");
                        }
                        tv_input.setText(null);
                        ACTION = DIVISION;
                    }
                } catch (Exception e) {
                    tv_output.setText("Error Syntax");
                    tv_input.setText("");
                }
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                } catch (Exception e) {
                    tv_output.setText("Error Syntax");
                    tv_input.setText("");
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_input.getText().length() > 0) {
                    CharSequence name = tv_input.getText().toString();
                    tv_input.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    tv_input.setText("");
                    tv_output.setText("");
                }
            }
        });

        // Long click clear all
        btn_clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                tv_input.setText("");
                tv_output.setText("");
                return true;
            }
        });
    }

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
    }

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

}