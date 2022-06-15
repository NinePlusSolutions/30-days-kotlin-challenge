package com.example.cotbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello()
//        var a : String = " "
//        a="man"
//        a.toInt()
//        val b : String=" anh"
//        var c: String? = null!!
//        c = "man"
//        var b : Int = 15
//        var a : Int = 10
////        if (a>b)
//            Log.d("BBB","Gia Tri lon nhat la" + a)
//        else
//            Log.d("BBB","Gia tri lon nhat la:" + b)
//        var d : Int = 17
//        when(d){
//            1,25,16 -> Log.d("aa","quy 1")
//            9,2,3 -> Log.d("aa","quy 2")
//            0,6,15 -> Log.d("aa","quy 3")
//        else -> Log.d("aa","khong co so phu hop")
//        }
//        var h :Int = 0
//        while (h<10){
//            Log.d("aaa","lap lai "+ h)
//            h++;
//        }
//        for (i in 0..10){
//            Log.d("aaa"," "+ i)
//        }
        }
    fun hello(){
        val firsNumber = 20
        val secondNumber = 19
        println("tong la : $firsNumber")
        println(" hieu la man: ${firsNumber - secondNumber}")
    }

}