class car(var brand: String, var model: String, var year: Int){
    fun dirve(){
        println("Wroom!")
    }

    fun speed(maxSpeed: Int){
        println("Max speed: " + maxSpeed)
    }
}
class Employee{
    var name: String =""
    var age: Int = 0
    var gender: Char = 'M'
    var salary: Double = 0.toDouble()

    fun insertValue(n:String, a:Int, g:Char, s:Double){
        name = n
        age = a
        gender = g
        salary = s
        println("Name of the employee: $name")
        println("Age of the employee: $age")
        println("Gender of the employee: $gender")
        println("Salary of the employee: $salary")
    }

    fun insertName(n: String){
        this.name = n
    }
}


