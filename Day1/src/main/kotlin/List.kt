fun main(args: Array<String>) {
    val immutableList = listOf(150,156,0,2,78)
    val valMutableList = mutableListOf("Carol","Dave")

    for (item in immutableList){
        when (item){
            0 -> println(item)
            in 1..9 -> println("$item is a one number")
            in 10..99 -> println("$item is two number")
            else -> println("$item is third number")
        }
    }
}