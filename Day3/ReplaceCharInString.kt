fun main() {
    var string = "Kotlin 1.3"
    val char = '_'
    val index = 6

    val chars = string.toCharArray()
    chars[index] = char
    string = String(chars)

    println(string)
}