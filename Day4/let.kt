fun main(args: Array<String>) {
//
//    // part 1
//    var str = "Hello World"
//    str.let { println("$it!!") } // Hello World!!
//    println(str) // Hello World
//    var strLength = str.let { "$it function".length }
//    println("strLength is $strLength") // strLength is 20
//
//    // part 2
//    var a = 1
//    var b= 2
//
//    a = a.let { it + 2 }.let { val i = it + b
//        i} // return@let i
//    println(a) //5

//    // part 3
//    var x = "Anupam"
//    x.let { outer ->
//        outer.let { inner ->
//            print("Inner is $inner and outer is $outer")
//        }
//    }

////    part 4
//    var x = "Anupam"
//    x = x.let { outer ->
//        outer.let { inner ->
//            println("Inner is $inner and outer is $outer")
//            "Kotlin Tutorials Inner let"
//        }
//        println(outer)
//        println(x)
//        "Kotlin Tutorials Outer let"
//    }
//    println(x) //prints Kotlin Tutorials Outer let


//    var name : String? = "Kotlin let null check"
//    name?.let { println(it) } //prints Kotlin let null check
//    name = null
//    name?.let { println(it) } //nothing happens


}