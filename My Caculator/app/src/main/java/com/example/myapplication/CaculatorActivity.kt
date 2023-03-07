package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_caculator.*

class CaculatorActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = " "
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caculator)
        btnEqual.setOnClickListener {
            equalevent()
        }

    }

    private fun addToInputText(buttonValue: String): String {
        return etinput.text.toString() + "" + buttonValue
    }

    fun numberEvent(view: View) {
        if (isNewOp)
            etinput.setText("")
        isNewOp = false
        var buclick = etinput.text.toString()
        var buselect = view as Button
        when (buselect.id) {
            btn1.id -> {
                buclick += resources.getString(R.string.num1)
            }
            btn2.id -> {
                buclick += resources.getString(R.string.num2)
            }
            btn3.id -> {
                buclick += resources.getString(R.string.num3)
            }
            btn4.id -> {
                buclick += resources.getString(R.string.num4)
            }
            btn5.id -> {
                buclick += resources.getString(R.string.num5)
            }
            btn6.id -> {
                buclick += resources.getString(R.string.num6)
            }
            btn7.id -> {
                buclick += resources.getString(R.string.num7)
            }
            btn8.id -> {
                buclick += resources.getString(R.string.num8)
            }
            btn9.id -> {
                buclick += resources.getString(R.string.num9)
            }
            btn0.id -> {
                buclick += resources.getString(R.string.num0)
            }


        }
        etinput.setText(buclick)
    }

    fun showResult(view: View) {
        isNewOp = true
        oldNumber = etinput.text.toString()
        val buselect = view as Button
        when (buselect.id) {
            btnPlus.id -> {
                op = "+"
            }
            btnMinus.id -> {
                op = "-"
            }
            btnMultiply.id -> {
                op = "*"
            }
            btnDivide.id -> {
                op = "/"
            }
        }
    }

    fun equalevent() {
        var newNumber = etinput.text.toString()
        var result = 0.0
        when (op) {
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()
            }
            "*" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/"->{
                result = oldNumber.toDouble() / newNumber.toDouble()
            }
        }
        etinput.setText(result.toString())
    }

    fun acEvent(view: View) {

        etinput.setText("0")
        isNewOp = true

    }


}