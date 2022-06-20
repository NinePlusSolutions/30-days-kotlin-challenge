/*  Scope Function : Let Function
*   Return : lambda result
*   Context object: it
* */
fun main() {
    val name: String? = "hello"

//    println(name!!.length)
//    println(name.reversed())

    val stringLength = name?.let {
        println(it.reversed())
        it.length
    }
    println(stringLength)
}