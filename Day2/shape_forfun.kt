fun main() {
    println("Enter number of edge: ")
    var numberEdge = Integer.valueOf(readLine())
    when(numberEdge) {
        3 -> for (i in 5 downTo 1 ) {
            println("#".repeat(i))
        }   
        4 ->   for (i in 1..4) {
            println("# ".repeat(5))
        }   
        else -> println("cant read that!")
    }
}