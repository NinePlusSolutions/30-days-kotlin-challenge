package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.currentNumber.observe(this, Observer {
            binding.tvTextview.text = it.toString()
        })
        viewModel.currentBoolean.observe(this, Observer {
            binding.tvBcd.text = it.toString()
        })
        increamentText()
    }

    private fun increamentText(){
            binding.btnAdd.setOnClickListener {
                viewModel.currentNumber.value =++ viewModel.number
                viewModel.currentBoolean.value = viewModel.number % 2 ==0

            }
    }
}