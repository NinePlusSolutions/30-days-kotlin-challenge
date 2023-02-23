package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_caculator.*
import kotlinx.android.synthetic.main.activity_caculator.view.*

class CaculatorActivity : AppCompatActivity() {

    var isNewOp=true
    var oldNumber=" "
    var op="+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caculator)



        btnc.setOnClickListener {
            etinput.setText(" ")
            etoutput.text=""
        }

        btnequal.setOnClickListener {
            equalevent()
        }

    }
    private fun addToInputText(buttonValue: String): String {
        return etinput.text.toString() + "" + buttonValue
    }


    fun numberEvent(view: View){
        if(isNewOp)
            etinput.setText("")
        isNewOp=false
        var buclick=etinput.text.toString()
        var  buselect= view as Button
        when(buselect.id){
            btn1.id->{buclick +="1"}
            btn2.id->{buclick +="2"}
            btn3.id->{buclick +="3"}
            btn4.id->{buclick +="4"}
            btn5.id->{buclick +="5"}
            btn6.id->{buclick +="6"}
            btn7.id->{buclick +="7"}
            btn8.id->{buclick +="8"}
            btn9.id->{buclick +="9"}
            btn0.id->{buclick +="0"}


        }
        etinput.setText(buclick)
    }
    fun showResult(view: View){
        isNewOp= true
        oldNumber=etinput.text.toString()
        val  buselect=view as Button
        when(buselect.id){
            btnplus.id->{op="+"}
            btnminus.id->{op="-"}
            btnmultiply.id->{op="*"}
            btndivide.id->{op="/"}
        }
    }
    fun  equalevent(){
        var newNumber =etinput.text.toString()
        var result= 0.0
        when(op){
            "+" ->{result = oldNumber.toDouble() + newNumber.toDouble()}
            "-"->{result = oldNumber.toDouble()- newNumber.toDouble()}
            "*"->{result = oldNumber.toDouble() * newNumber.toDouble()}
            "/"->{result = oldNumber.toDouble() / newNumber.toDouble()}
        }
        etinput.setText(result.toString())
    }
}