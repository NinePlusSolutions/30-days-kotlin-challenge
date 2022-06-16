import java.util.*

fun main(args: Array<String>) {
    var M:DoubleArray= DoubleArray(10)
    var rand = Random()
    for (i in M.indices)
        M[i] = rand.nextDouble()
    for (item in M)
        print("$item \t")
    M.sortDescending()
    println("Dẫy sau khi sắp xếp:")
    for (item in M)
        print("$item \t")

}