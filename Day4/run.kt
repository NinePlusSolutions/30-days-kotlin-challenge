fun main() {
    class Person(var name : String, var age: Int, var address: String) {
        override
        fun toString(): String {
            return "Name: ${name}, age: ${age}, address: ${address}"
        }
    }
    val person = Person("Nguyen Van A", 23, "Quang Nam")
    val value = person.run {
        
        address
    }
    println(value)
    // output: "Da Nang"

}