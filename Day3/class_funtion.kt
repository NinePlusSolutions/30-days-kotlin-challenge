class Car(var brand: String, var model: String, var year: Int){
    fun drive(){
        println("Bruhhhh")
    }
}

fun main() {
    val car = Car("Ford", "Mustang", 1956 )

    println(car.brand + " " + car.model + " " + car.year)

    car.drive()
}