/*  Scope Function : Let Function
*   Return : lambda result
*   Context object: this
*   'run' is combination of with and let
*   if you want a Nullable object and avoid NullPointer use 'run'
* */
fun main() {
    val person: Person? = null

//    val bio: Int = with(person) {
//        println(name)
//        println(age)
//        age + 6
//    }
    val bio = person?.run {
        println(name)
        println(age)
        age + 6
    }
    println(bio)
}