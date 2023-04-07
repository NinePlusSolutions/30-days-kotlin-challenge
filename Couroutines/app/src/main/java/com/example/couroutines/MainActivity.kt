package com.example.couroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG="coroutine in android"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
//            delay(1000)
            val netWork = doNetWorkCall()
            val netWork2 = doNetWorkCall1()

            Log.d(TAG,netWork)
            Log.d(TAG,netWork2)
        }
    }

    suspend fun doNetWorkCall() : String{

        delay(3000L)

        return "This is MainActivity"
    }
    suspend fun doNetWorkCall1():String{
        delay(3000L)
        return "This is answer"
    }
}