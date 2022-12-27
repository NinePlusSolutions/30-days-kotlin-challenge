package Class

class innerClass {
    private val welcomeMessage:String = "Welcome to the TutorialPoint.Com"
    private val a = 20
    private val b = 30
    inner class Inner{
        fun  foo() = welcomeMessage
        fun sum():Int {
            return a+b
        }
    }
}