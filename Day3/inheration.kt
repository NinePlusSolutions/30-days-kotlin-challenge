// Superclass
open class MyParentClass {
    val x = 5
    fun printString (content: String) {
        println("The content is: " +content)
    }
}

// Subclass
class MyChildClass: MyParentClass() {
    fun myFunction() {
        printString("hehe")
        println(x) // x is defined in the superclass
    }
}

// Create an object of the MyChildClass and call myFunction
fun main() {
    val myObj = MyChildClass()
    myObj.myFunction()
}