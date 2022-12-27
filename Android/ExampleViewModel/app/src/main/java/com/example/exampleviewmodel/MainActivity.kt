package com.example.exampleviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.exampleviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        var viewModel: ActivityViewModel = ViewModelProvider(this)[ActivityViewModel::class.java]

        binding?.btnCount?.setOnClickListener {
            viewModel.addNumber()
            binding?.tvNumber?.text = viewModel.number.toString()
        }
    }
}