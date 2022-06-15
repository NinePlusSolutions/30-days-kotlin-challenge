class Spaceship(var name:String, val size:Int) {
    var speed: Int = 0
    fun fly(){
        speed = 100
    }
    fun isFlying():Boolean {
        return speed > 0
    }
    //  Companion object replaces static member
    companion object {
        fun newSpaceship(): Spaceship{
            print("Companion")
            return Spaceship("Falcon", 25)
        }
    }
}
fun main(args: Array<String>) {
    val myShip= Spaceship("Enterprise", 150)
    myShip.fly()
    val flying = myShip.isFlying()
    print(flying)
}