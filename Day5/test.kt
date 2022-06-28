fun main() {

    var str1 = "I "
    var str2 = "love "
    var str3 = "kotlin"

    print(str1.add(str2, str3))
}

fun String.add(str2: String, str3: String): String{
    return this + str2 + str3
}

