class TheLongestWord(var text: String) {

    fun getLongestWord() {
        var longestWord = 0
        var newString:String = ""
        val words = text.split(" ")

        words.forEach {
            if ( it.length > longestWord){
                newString = it
                longestWord = it.length
            }
        }

        println("length Longest Word : " + longestWord)
        println(newString)
    }
}


fun main() {
    val tmp= TheLongestWord( "hEllo World ádasdasdasd") //Hello World
    tmp.getLongestWord()
}