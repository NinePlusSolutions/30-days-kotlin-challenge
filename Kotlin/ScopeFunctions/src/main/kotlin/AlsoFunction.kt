/*  Scope Function : Also Function
*   Return : context object
*   Context object: it
* */

fun main(){
    val numbersList: MutableList<Int> = mutableListOf(1,2,3)
    val duplicateNumbers = numbersList.also {
        println("The list element are: $it")
        it.add(4)
        println("The list element after adding an element: $it")
        it.remove(2)
        println("The list element after removing an element: $it")
    }
    println("Original numbers: $numbersList")
    println("Duplicate numbers: $duplicateNumbers")
}