class Car(var brand: String, var model: String, var year: Int){
    fun drive(){
        println("Bruhhhh")
    }

    fun speed(maxSpeed: Int){
        println("The max speed is: " +maxSpeed)
    }
}

fun main() {
    val car = Car("Ford", "Mustang", 1956 )

    println(car.brand + " " + car.model + " " + car.year)

    car.drive()
    car.speed(500)
}