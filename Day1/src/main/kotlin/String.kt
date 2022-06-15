fun main(args: Array<String>) {
    //Characters or Char
    var c: Char = 'c';
    //@ U+00400
    c = '\u0040';
    println("copyright char  = $c ");
    val myName = "Khanh";
    for (eachChar in myName) {
        println("eachChar = $eachChar");
    }
    val strings: Array<String> = arrayOf("a", "b", "c", "d");
    for (string in strings) {
        println("string is $string");
    }
    val intNumbers: Array<Int> = Array<Int>(5, { i -> 2 * i });
    for (intNumber in intNumbers) {
        println("intNumber = $intNumber");
    };
    val text = """
            |Hello my name David
            |Email : lnkhanh.20it2@vku.udn.vn
        """.trimMargin("|");
    println("text  = $text");
}
