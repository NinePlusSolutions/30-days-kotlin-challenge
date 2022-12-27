/*  Scope Function : With Function
*   Return: lambda result
*   Context Object: this
*  */
fun main(){
    val person = Person()

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
class Person{
    var name: String = "Võ Anh Nguyen"
    var age: Int = 22
}