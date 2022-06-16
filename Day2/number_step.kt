fun main() {
    val lastNumber = 10
    for(index in 0..lastNumber step 2){
        println(index)
    }
    
    var firstNumber = 0
    var secondNumber = 1
    
    print("First $lastNumber terms: ")

    for (i in 1..lastNumber) {
        if (firstNumber <= lastNumber)
        {
            print("$firstNumber, ")
        }
        val sum = firstNumber + secondNumber
        firstNumber = secondNumber
        secondNumber = sum
    }
}