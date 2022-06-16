class CapitalizeFirstLetter(var text:String){

    fun capitalizeFirstLetter(){

        var oldString = text.toLowerCase()
        var newString = ""
        val words = oldString.split(" ")

        words.forEach {
            newString += it.capitalize() + " "
        }

        println(newString)
    }

}

fun main() {
    val tmp= CapitalizeFirstLetter( "hEllo World") //Hello World
    tmp.capitalizeFirstLetter()
}