/*  Scope Function : Apply Function
*   Return : context object
*   Context object: this
* */
fun main() {
//    val person = Person()
//    person.name = "Khanh Le Ngoc"
//    person.age = 21

//    val person = Person()
//        person.apply {
//        name = "Khanh Le Ngoc"
//        age = 19
//    }

    val person = Person().apply {
        name = "Khanh Le Ngoc"
        age = 19
    }

    with(person){
        println(name)
        println(age)
    }


}