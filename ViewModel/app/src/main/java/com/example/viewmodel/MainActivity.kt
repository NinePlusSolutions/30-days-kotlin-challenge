package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var mCounterViewModel: CounterViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCounterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        displayCount()
    }

    fun displayCount() {
        val tvCount = findViewById<TextView>(R.id.tvCount)
        tvCount.text = mCounterViewModel?.count.toString()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnUp -> {
                mCounterViewModel?.count = mCounterViewModel?.count!! + 1
                displayCount()
            }

            R.id.btnDown -> {
                mCounterViewModel?.count = mCounterViewModel?.count!! - 1
                displayCount()
            }
        }
    }

}