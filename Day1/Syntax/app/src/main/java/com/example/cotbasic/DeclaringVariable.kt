package com.example.cotbasic

fun main(){
    var mutable = 1
        mutable = 3        // ok, you can reassign a var
    val immutable : Double = 2.0
        //immutable = 3.0 // You can't reassign a val
    val arrayOfNumbers = arrayOf ( 2 , 3 , 5 , 6 , 10 )
    for (number in arrayOfNumbers) {
        println (number)
    }
    var arched : String? = null
        arched = " Hey, what's up, everybody"
    val lengthOfName = arched.length
    println("length = $lengthOfName")
    var name : String? = null
    name = "man le"
    var length3 :Int = name.length
    println(length3)
}