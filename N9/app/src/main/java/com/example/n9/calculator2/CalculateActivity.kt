package com.example.n9.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.n9.R
import kotlinx.android.synthetic.main.activity_calculate.*

class CalculateActivity : AppCompatActivity() {
    var operator = ""
    var abc: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)
        eventListener(abc)
    }

    private fun eventListener(asd: String?) {
        if (asd != null) tvInput.text = asd
        asd?.also { it -> tvInput.text = it }

        btnNum1.setOnClickListener {
            setNumber(resources.getString(R.string.btn1))
        }
        btnNum2.setOnClickListener {
            setNumber(resources.getString(R.string.btn2))
        }
        btnNum3.setOnClickListener {
            setNumber(resources.getString(R.string.btn3))
        }
        btnNum4.setOnClickListener {
            setNumber(resources.getString(R.string.btn4))
        }
        btnNum5.setOnClickListener {
            setNumber(resources.getString(R.string.btn5))
        }
        btnNum6.setOnClickListener {
            setNumber(resources.getString(R.string.btn6))
        }
        btnNum7.setOnClickListener {
            setNumber(resources.getString(R.string.btn7))
        }
        btnNum8.setOnClickListener {
            setNumber(resources.getString(R.string.btn8))
        }
        btnNum9.setOnClickListener {
            setNumber(resources.getString(R.string.btn9))
        }
        btnNum0.setOnClickListener {
            setNumber(resources.getString(R.string.btn0))
        }
        btnMinus.setOnClickListener {
            setOpe("-")
        }
        btnTimes.setOnClickListener {
            setOpe("X")
        }
        btnPlus.setOnClickListener {
            setOpe("+")
        }
        btnDivide.setOnClickListener {
            setOpe("/")
        }
        btnE.setOnClickListener {
            val number = tvInput.text.split(operator)
            Log.d("Total", "${number.size}")
            Log.d("Total", "${number}")
            if (number.last().isNotEmpty() && number.first().isNotEmpty()) {
                when (operator) {
                    "X" -> tvOutPut.text =
                        (number.first().toInt() * number.last().toInt()).toString()
                    "+" -> tvOutPut.text =
                        (number.first().toInt() + number.last().toInt()).toString()
                    "-" -> tvOutPut.text =
                        (number.first().toInt() - number.last().toInt()).toString()
                    else -> if (number.last() != "0") {
                        tvOutPut.text = (number.first().toInt() / number.last().toInt()).toString()
                    } else {
                        tvOutPut.text = "Cannot Divide By Zero"
                    }
                }
            } else
                tvOutPut.text = number.first().toString()
        }
        btnDelete.setOnClickListener {
            tvInput.text = tvInput.text.dropLast(1)
            if (tvInput.text.isEmpty()) {
                tvInput.text = "0"
            }
        }
        btnDelete.setOnLongClickListener {
            tvInput.text = "0"
            tvOutPut.text = ""
            operator = ""
            true
        }
    }
    fun setOpe(ope: String) {
        if (operator == "") {
            tvInput.text = "${tvInput.text}$ope"

        } else {
            tvInput.text = tvInput.text.toString().replace(operator, ope)
        }
        operator = ope
    }

    fun setNumber(number: String) {
        if (tvOutPut.text.isNotEmpty()) {
            tvInput.text = "0"
            tvOutPut.text = ""
            operator = ""
        }
        if (tvInput.text == "0") {
            tvInput.text = ""
        }
        tvInput.text = "${tvInput.text}$number"
    }
}