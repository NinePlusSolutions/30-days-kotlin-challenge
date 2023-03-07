package com.example.caculatormvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.caculatormvp.Presenter.PresenterClass
import com.example.caculatormvp.Presenter.PresenterInterface
import com.example.caculatormvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , PresenterInterface.View {

lateinit var binding:ActivityMainBinding
lateinit var presenter: PresenterInterface.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        presenter= PresenterClass(this)
        clickButton()
        operator()

    }

    fun clickButton(){
        binding.btn0.setOnClickListener {
            presenter.onButtonClick(binding.btn0.text.toString())
        }
        binding.btn1.setOnClickListener {
            presenter.onButtonClick(binding.btn1.text.toString())
        }
        binding.btn2.setOnClickListener {
            presenter.onButtonClick(binding.btn2.text.toString())
        }
        binding.btn3.setOnClickListener {
            presenter.onButtonClick(binding.btn3.text.toString())
        }
        binding.btn4.setOnClickListener {
            presenter.onButtonClick(binding.btn4.text.toString())
        }
        binding.btn5.setOnClickListener {
            presenter.onButtonClick(binding.btn5.text.toString())
        }
        binding.btn6.setOnClickListener {
            presenter.onButtonClick(binding.btn6.text.toString())
        }
        binding.btn7.setOnClickListener {
            presenter.onButtonClick(binding.btn7.text.toString())
        }
        binding.btn8.setOnClickListener {
            presenter.onButtonClick(binding.btn8.text.toString())
        }
        binding.btn9.setOnClickListener {
            presenter.onButtonClick(binding.btn9.text.toString())
        }
        binding.btn0.setOnClickListener {
            presenter.onButtonClick(binding.btn0.text.toString())
        }

    }
    fun operator(){
        binding.btnPlus.setOnClickListener {
            presenter.forCalculation(binding.btnPlus.text.toString())
        }

        binding.btnMinus.setOnClickListener {
            presenter.forCalculation(binding.btnMinus.text.toString())
        }
        binding.btnMultiply.setOnClickListener {
            presenter.forCalculation(binding.btnMultiply.text.toString())
        }
        binding.btnDivide.setOnClickListener {
            presenter.forCalculation(binding.btnDivide.text.toString())
        }
        binding.btnEqual.setOnClickListener {
            presenter.onEqual(binding.etinput.text.toString())
        }
        binding.btnc.setOnClickListener {
            presenter.onDelte(binding.btnc.text.toString())
        }
    }

     override fun show(number: String) {

         binding.etinput.text="${binding.etinput.text}$number"
    }

    override fun result(result: Double) {
        binding.etinput.text=result.toString()
    }

    override fun onError() {
        Toast.makeText(this,"cannot divide by zero",Toast.LENGTH_SHORT).show()
    }

    override fun onDelete(value: String) {
    }


}