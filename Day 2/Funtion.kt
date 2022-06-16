package com.example.cotbasic

fun sayHello(name: String) {
    println("Hello today,$name")
}

fun sayFriend(name1: String = "friend") {
    println("hi,$name1")
}

fun createCat(name: String, age: Int, isSpayed: Boolean = false) {
    println("$name, $age, $isSpayed")
}

fun total(x: Int, y: Int) = x + y

fun product(x: Int, y: Int) = x * y

fun doMath(mathOperation: (Int, Int) -> Int, a: Int, b: Int): Int {
    return mathOperation(a, b)
}

val add = doMath(::total, 3, 4)
val multiply = doMath(::product, 5, 6)

fun main() {
    sayHello("Khanh")
    sayFriend("my love")
    createCat("Tom", 40, true)
    println("Total is ${total(20,30)}")
    println("Product is ${product(2,30)}")
    println("Add is $add, Multiply is $multiply")

}