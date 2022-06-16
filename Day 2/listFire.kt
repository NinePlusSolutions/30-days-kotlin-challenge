package com.example.cotbasic
fun sayList(){
    val names:MutableList<String> = mutableListOf("Jessica", "Henry", "Alicia", "Jose")
//    for(name in names){
//        println("$name, Number of character : ${name.length}")
////    }
//    println("Size of the names ${names.size}")
//    names.forEach{
//        i->
//        println(i)
//    }
    names.add("Tom")
    println("Size of the names ${names.size}")
    names.forEach{
            i->
        println(i)
    }
    println("location three is: ${names[3]}")

}
fun main() {
    val number = listOf(1, 3, 4, 5, 6, 5)
    println("List : $number,${number.size}")
    println("First element: ${number[0]}")
    println("Last index: ${number.size - 1}")
    println("Last element: ${number[number.size - 1]}")
    println("First: ${number.first()}")
    println("Last: ${number.last()}")

    // Use the contains() method
    println("Contains 4? ${number.contains(4)}")
    println("Contains 7? ${number.contains(7)}")
    println("Sorted list: ${number.sorted()}")
    sayList()


}