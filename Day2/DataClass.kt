// A data class is a structured data container
// with pre-defined toString() and other overrides
data class Student(val name: String, var year: Int)
// name is a read-only property, year is mutable
val newStudent = Student("Siddartha",1)
data class Professor( val name:String){
    var isTenured: Boolean = false
}
fun main(args: Array<String>) {
    val newProfessor = Professor("Snape")
    newProfessor.isTenured = true
}