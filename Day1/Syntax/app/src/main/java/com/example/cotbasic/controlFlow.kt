package com.example.cotbasic
fun main(){
    val firstNumber = 10
    val secondNumber = 25
    val max = if(firstNumber>secondNumber){
        println("$firstNumber is max")
        firstNumber
    }else{
        println("$secondNumber is max")
        secondNumber
    }
    println("Max = $max")
    val numberOne = 19
    val numberTwo = 21
    //
    when(numberOne){
        numberTwo/2 -> println("$numberOne = $numberTwo /2")
        else -> println("$numberOne != $numberTwo /2")
    }
    // Using when to choose different paths
    val year =  2010
    when(year){
        2010 -> print(" Hello HCM")
        2008,2009 -> print(" Hello QT")
        in 2012..2015 ->{
            println("Hell DAKLAK")
        }
        else-> println("Hello TTH")
    }
    //
    val listOfNumber = listOf<Int>(1, 2, 3, 4, 5, 6)
    for (number in listOfNumber){
        if(number%2==0){
            println("$number is even number")
        }else{
            println("$number is odd number")
        }
    }
}