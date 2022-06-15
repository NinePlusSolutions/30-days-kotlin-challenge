package com.example.day1

import android.util.Log

fun main(){
    branching2()
    branching1()
}
//if else
fun branching1 (){
    var a :Int=2
    var b :Int=3
    if (a<b){
        print("b lon hon a")
    }else{
        print("b nho hon a")
    }
}
//when
fun branching2(){
    var a :String ="duong"
    when(a){
        "cong" ->print("chao cong")
        "phu" ->print("chao phu")
        "duong" -> print("chao duong")

    }


}