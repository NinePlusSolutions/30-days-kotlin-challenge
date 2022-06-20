/*  Scope Function : With Function
*   Return: lambda result
*   Context Object: this
*  */
class Person {
    var name: String = "Le Ngoc Khanh"
    var age: Int = 20
}

fun main() {
    val person = Person()
//    println(person.name)
//    println(person.age)

    with(person){
        println(this.name)
        println(this.age)
    }

    with(person){
        println(name)
        println(age)
    }

   var ageAfterFiveYear: Int = with(person){
        println(name)
        println(age)
        age +5
    }
    println("Age after 5 year $ageAfterFiveYear")
}