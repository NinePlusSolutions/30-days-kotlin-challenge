package com.example.n9.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.n9.R
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {
    var i = 0
    var x = 0
    var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        eventListener()
    }

    fun setText(string: String){

    }
    @SuppressLint("SetTextI18n")
    fun eventListener(){
        text1.setOnClickListener {
            text.text = "${text.text}1"
        }
        text2.setOnClickListener {
            text.text = "${text.text}2"
        }
        text3.setOnClickListener {
            text.text = "${text.text}3"
        }
        text4.setOnClickListener {
            text.text = "${text.text}4"
        }
        text5.setOnClickListener {
            text.text = "${text.text}5"
        }
        text6.setOnClickListener {
            text.text = "${text.text}6"
        }
        text7.setOnClickListener {
            text.text = "${text.text}7"
        }
        text8.setOnClickListener {
            text.text = "${text.text}8"
        }
        text9.setOnClickListener {
            text.text = "${text.text}9"
        }
        text0.setOnClickListener {
            text.text = "${text.text}0"
        }
        textP.setOnClickListener {
            operator = "+"
            if(text.text.isEmpty()){
                i = 0

            }else{
                i = text.text.toString().toInt()
            }
            text.text = ""


        }
        textE.setOnClickListener {
            when(operator){
                "+" -> {
                    if(text.text.isEmpty()){
                        text.text = i.toString()
                    }else{
                        text.text = "${i+text.text.toString().toInt()}"
                    }
                }
                "-" -> {
                    if(text.text.isEmpty()){
                        text.text = i.toString()
                    }else{

                    }
                }

                else ->{
                    if(text.text != "0"){
                        text.text = "${i/text.text.toString().toInt()}"

                    }



            }
        }

        }
    }


}