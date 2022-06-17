package OOP


data class UserDTO(val name: String, val job: String, val age: Int,){
    fun name(){
        println(name)
    }
}


fun main() {
    // Destructuring Declarations
    val u1 = UserDTO("John","doctor", 29)
    val (name,job,age) = u1
    u1.name()
    println("name = $name")
    println("age = $age")
}