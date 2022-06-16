fun main() {
    println("Enter number: ")
    val number = Integer.valueOf(readLine())
    println("***Start: ***")
    for (index in 1..number) {
        if (index % 5 ==0 && index % 3 ==0){
            println("FizzBuzz")
        } else if(index % 5 ==0){
            println("Buzz")
        }else if(index % 3 ==0){
            println("Fizz")
        }else{
            println(index)
        }
    }
}