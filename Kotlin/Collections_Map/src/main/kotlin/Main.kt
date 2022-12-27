fun main(args: Array<String>) {
    val myMap: Map<Char,Int> = mapOf<Char,Int>('a' to 10, 'b' to 20, 'c' to 30)

    for (key: Char in myMap.keys){
        println("Element at $key = ${myMap.get(key)}") // we can also use myMap[key] to print its values
    }

    println()

    var myMap2: HashMap<Char, Int> = HashMap<Char,Int>()
    //
    myMap2.put('d',40)
    myMap2.put('e',50)
    myMap2.put('f',60)

    for (key: Char in myMap2.keys){
        println("Element at $key = ${myMap2.get(key)}")
    }
    // we can replace the value related to key in maps
    myMap2.replace('e',400) // or we can use put method that works as well
    println(myMap2)
}