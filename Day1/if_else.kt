fun main() {
    // a simple sample
    if (5>7){
        println("aa")
    } else{
        println("bb")
    }

    // if can also be used as an expression.
    var a = 4
    var b = 5
    val max = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }
    println("max is $max")
}