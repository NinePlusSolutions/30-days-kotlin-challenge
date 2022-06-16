import kotlin.random.Random

fun main(args: Array<String>) {
    //khai bao mang hai chieu 10 dong 5 cot
    var M :Array<IntArray> =Array(10,{IntArray(5)})
    var rand= Random
    for (i in M.indices){
        for(j in M[i].indices){
            M[i][j]=rand.nextInt(100)
        }
    }
    println("mang 2 chieu")
    for (i in M.indices){
        for(j in M[i].indices){
            println("${M[i][j]}\t")
        }
        println()
    }
    


}