package com.example.playwithcoroutines.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class HomeViewModel : ViewModel() {
     fun start(){
        viewModelScope.launch {
            getDataFromServer()
        }

//        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
//        scope.launch {
//            getDataFromServer()
//        }
     }

    private suspend fun getDataFromServer(){
        Log.i(TAG,"Getting data ....")
        delay(1000L)
        Log.i(TAG,"Got the data")
    }

    fun stop(){
        viewModelScope.cancel()
    }

    companion object{
        const val TAG = "MainActivity"
    }
}