package com.example.calculatormvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.calculatormvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter: MainContract.Presenter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = MainPresenter(this)
        setUpEventListener()
//        binding.text1.setOnClickListener {
//           // Log.d("resultB: ", "${binding.text.text}")
//            presenter.buttonClickNumber(binding.text1.text.toString())
//
//        }
//
//        binding.text2.setOnClickListener {
//            presenter.buttonClickNumber(binding.text2.text.toString())
//        }
//
//        binding.textP.setOnClickListener {
//            presenter.add(binding.text.text.toString())
//        }

    }

    private fun setUpEventListener() {
        binding.btnNum0.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum0.text.toString())
        }
        binding.btnNum1.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum1.text.toString())
        }
        binding.btnNUm2.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNUm2.text.toString())
        }
        binding.btnNum3.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum3.text.toString())
        }
        binding.btnNum4.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum4.text.toString())
        }
        binding.btnNum5.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum5.text.toString())
        }
        binding.btnNum6.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum6.text.toString())
        }
        binding.btnNum7.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum7.text.toString())
        }
        binding.btnNum8.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum8.text.toString())
        }
        binding.btnNum9.setOnClickListener {
            presenter.buttonClickNumber(binding.btnNum9.text.toString())
        }
        binding.btnPlus.setOnClickListener {
            presenter.operator(binding.btnPlus.text.toString())
        }
        binding.btnSub.setOnClickListener {
            presenter.operator(binding.btnSub.text.toString())
        }
        binding.btnMultiplication.setOnClickListener {
            presenter.operator(binding.btnMultiplication.text.toString())
        }
        binding.btnDivide.setOnClickListener {
            presenter.operator(binding.btnDivide.text.toString())
        }
        binding.btnDelete.setOnClickListener {
            presenter.delete(binding.textInput.text.toString())
        }
        binding.btnDelete.setOnLongClickListener {
            presenter.delete("")

            true
        }

        binding.btnEqual.setOnClickListener {
//            when(operator){
//                "+" -> presenter.add(binding.textInput.text.toString())
//                "-" -> presenter.sub(binding.textInput.text.toString())
//
//
//            }
            presenter.equal(binding.textInput.text.toString())
        }
    }
    override fun onButtonClicked(number: String) {
        binding.textInput.text = "${binding.textInput.text}$number"
        // Log.d("result: ", "${binding.textInput.text}$number")
    }
    override fun showResult(result: Int) {
        binding.textOutput.text = result.toString()
        // Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
    override fun showError() {
        Toast.makeText(this, "Can not divide by Zero", Toast.LENGTH_SHORT).show()
    }

    override fun showDelete(number: String) {
        binding.textInput.text = number
    }
}