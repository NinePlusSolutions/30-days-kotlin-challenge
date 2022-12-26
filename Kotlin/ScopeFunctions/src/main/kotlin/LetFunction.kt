/*  Scope Function : Let Function
*   Return : lambda result
*   Context object: it
* */
fun main(){
    val name:String? = "Hello"
    val stringLength = name?.let {
        println(it.reversed())
        it.length
    }
    println(stringLength)
}