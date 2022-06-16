fun main() {
    println("Enter number: ")
    var inputNumber = Integer.valueOf(readLine())
    for (index in 1..inputNumber) {
        // repeat same the multiply a string
        println("#".repeat(index))
    }
}