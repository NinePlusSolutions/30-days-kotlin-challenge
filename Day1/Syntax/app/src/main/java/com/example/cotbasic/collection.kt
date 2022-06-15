package com.example.cotbasic
data class Worker(
    val id: Int,
    val name: String
)
fun main() {
    val list = mutableListOf(2, 3, 5, 6, 7)
    list[2] = 100  // works now
    println(list[2]) // 100
    list.add(index = 3, element = 500)
    println(list[3]) // 500
    list.remove(7)
    println(list) // [2, 3, 100, 500, 6]
    list.removeAt(0)
    println(list)

    val workers = setOf(
        Worker(id = 5, name = "Filip"),
        Worker(id = 3, name = "Mike"),
        Worker(id = 5, name = "Filip"),
        Worker(id = 4, name = "Filip")
    )
    // hashcode is used to remove duplicates
    println(workers)
}
