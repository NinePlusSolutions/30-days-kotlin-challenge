package com.ngockhanh.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }
    lateinit var btnData: Button
    lateinit var tvText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.tvText)

        findViewById<Button>(R.id.btnStart).setOnClickListener {
            requestWithCoroutines()
        }

    }

    private fun requestWithCoroutines() {
       /* val mainScope =
            CoroutineScope(Dispatchers.Main)
        mainScope.launch {
            Log.i(TAG,"main scope with thread ${Thread.currentThread().name}")

            withContext(Dispatchers.IO){
                Log.i(TAG,"in io scope with thread ${Thread.currentThread().name}")
                delay(1000L)
            }
            Log.i(TAG,"main scope after withcontext thread ${Thread.currentThread().name}")
            tvText.text = "data from server"

        }*/
//        val ioScope =
//            CoroutineScope(Dispatchers.IO)
//        ioScope.launch {
//            Log.i(TAG,"io scope with thread ${Thread.currentThread().name}")
//        }
//        val defaultScope =
//            CoroutineScope(Dispatchers.Default)
//        defaultScope.launch {
//            Log.i(TAG,"default scope with thread ${Thread.currentThread().name}")
//        }
        /*  Unconfined
        * */
//        val unconfinedScope =
//            CoroutineScope(Dispatchers.Unconfined)
//        unconfinedScope.launch {
//            Log.i(TAG,"main scope with thread ${Thread.currentThread().name}")
//
//            withContext(Dispatchers.IO){
//                Log.i(TAG,"in io scope with thread ${Thread.currentThread().name}")
//                delay(1000L)
//            }
//            Log.i(TAG,"main scope after withcontext thread ${Thread.currentThread().name}")
//
//        }

    }

    private fun requestData() {
        Log.i(TAG,"requestData on ${Thread.currentThread().name}")
        Thread.sleep(10000L)
        tvText.text = "data from server"

    }
    private fun requestDataWithSuspend(){
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        scope.launch {
            Log.i(TAG,"requestDataWithSuspend on ${Thread.currentThread().name}")
            delay(10000L)
            tvText.text = "data from server"
        }
    }
}