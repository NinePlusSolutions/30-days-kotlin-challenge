fun main(args: Array<String>) {
    // Subclassing: only open classes can be subclasses
    open class Crewmember(val name:String){
        // Only open methods can be overridden
        open fun sayHello() = "Hello, I'm crewmember $name."
    }

    // Subclassing
    class Captain(name:String) : Crewmember(name){
        override fun sayHello() = "Greetings, I'm Captain $name."
    }
}