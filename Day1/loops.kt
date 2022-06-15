fun main() {
    val items = listOf("apple", "banana", "kiwifruit")
    println("for loops")
    for (index in items.indices) {
        // "{}" maybe is a operator
        println("item at $index is ${items[index]}")
    }
    println("=========================")
    println("while loops")
    var index = 0
    while (index < items.size){
        println("item at $index is ${items[index]}")
        index++
    }
    println("======")
    println("do while")
    var indexx = -1
    do{
        indexx++
        println("item at $indexx is ${items[indexx]}")
    } while(indexx <= items.size-1)
}