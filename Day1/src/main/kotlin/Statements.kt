fun main(args: Array<String>) {
// if-else statement
    var condition = true
    if (condition) {
        println("True")
    } else {
        println("False")
    }

    var x = 100
    var y = 1
    val more = if (x > y) x else y
    val less = if (x < y){
        println("x is smaller")
        x
    } else {
        println("y is smaller")
        y
    }
    println("$more")
    println("$less")
//  When statement
    var no=1
    when (no) {
        0  -> println("no is zero")
        in 1..39 -> println("no is in range 1 to 39")
        else -> println("no is greater than 29")
    }
    val year = 2002
    val androidVer = when (year){
        2002 -> "Too old"
        in 2003..2014  ->"Need upload"
        else -> "New"
    }
    println("$androidVer")
}