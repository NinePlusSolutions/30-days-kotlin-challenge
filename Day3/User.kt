package OOP

class User (val userDTO: UserDTO){
    var job: String
    get() = "${userDTO.job}"
    set(value){
        job = value
    }
}


fun main() {
    val uDTO = UserDTO("John","doctor", 29)
    val u = User(uDTO)
    println("job = ${u.job}")
}