package com.example.day1

import android.util.Log

fun main() {
    vonglap1()
}
//vong lap while
fun vonglap1(){
    var a:Int=5
    while (a<10){
        print("\nchao ban lan thu"+a)
        a++

    }
}
//vong lap for
fun vonglap2(){
    var a:Int=10
    for(i in 0..a step 2){
        print("\ngia tri la"+i)
    }
}