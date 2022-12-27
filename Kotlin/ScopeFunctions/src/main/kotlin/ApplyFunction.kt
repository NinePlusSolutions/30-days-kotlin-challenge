/*  Scope Function : Apply Function
*   Return : context object
*   Context object: this
* */
fun main(){
    val person = Person().apply {
        name = "Võ Anh Nguyên"
        age = 21
    }
    with(person){
        println(name)
        println(age)
    }
}