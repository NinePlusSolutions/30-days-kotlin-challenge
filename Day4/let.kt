fun main() {
    class Person(var name : String, var age: Int, var address: String) {
        override
        fun toString(): String {
            return "Name: ${name}, age: ${age}, address: ${address}"
        }
    }
    val person = Person("Nguyen Van A", 23, "Quang Nam")
    val value = person.let {
        println(it.name)
        println(it.age)
        it.name
    }
    println(value)
    // output = Nguyen Van A
    // println(person.toString()) 
}