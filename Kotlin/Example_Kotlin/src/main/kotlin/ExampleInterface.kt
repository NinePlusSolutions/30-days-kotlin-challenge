interface ExampleInterface {
    var myVar: Int
    fun absMethod():String

    fun hello(){
        println("Hello there, Welcome to TutorialsPoint.Com!")
    }
}
class InterfaceImp: ExampleInterface{
    override var myVar: Int = 25
    override fun absMethod(): String = "Happy learning"
}