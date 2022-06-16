fun Product(list: List<Int>): Int {
//    val strings = listOf("a", "b", "c", "d")
//    println(strings.reduce { acc, string -> acc + string }) // abcd

// The reduce() method transforms a given collection into a single result.
// . It takes a lambda function operator to combine a pair of elements into a so-called accumulated value.

//  inline fun IntArray.reduce(
//     operation: (acc: Int, Int) -> Int
//  ): Int
    return list.reduce { accumulated, current -> accumulated * current }
}

fun Sum(list: List<Int>): Int {
    val sum: Int = list.reduce { acc, next -> acc + next }
    return sum
}

fun main() {
//    print(Product(listOf(1, 2,3,4,5)))
    print(Sum(listOf(1, 2,3,4,5)))
}