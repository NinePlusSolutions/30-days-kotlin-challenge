fun main(){
    var ch = 'G'

    when(ch){

        'A', 'E', 'I', 'O', 'U' -> println("$ch is a Vowel")

        else -> println("$ch is a Consonant")
    }

    var listNum = listOf(1500, 156, 0, 2, 78) 
    
    for (index in listNum) {
        println(index)
        when(index){
            0 -> println("$index is a zero number")
            in 1..9 -> println("$index is a single digit number")
            in 10..99 -> println("$index is a two digit number")
            in 100..999 -> println("$index is a three digit number")
            else -> println("$index is more than three digit number or negative number")
        }
    }
    
}