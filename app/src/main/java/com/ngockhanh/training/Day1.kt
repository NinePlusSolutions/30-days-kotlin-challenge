package com.ngockhanh.training

fun main(){
    fun printHello(){
        println("Hello World")
    }
    printHello()

    var no = 1
        when (no){
            0 -> println("no in zero")
            in 1..39 -> println("no in range 1 to 39")
            else -> println("no is greater than 29")
        }
}