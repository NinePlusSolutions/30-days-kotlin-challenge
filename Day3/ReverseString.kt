fun Reverse1( str: String): String {
    var reversed = ""
    str.forEach {
        reversed = it + reversed
    }
    return reversed
}
fun Reverse2( str: String): String {
    return str.foldRight("") { char, reversed -> reversed + char }
}

fun main() {
    print(Reverse1("123456789"))
}