/*
* Set in the Kotlin are same as that of the mathematical set.
* We can do the operation on the sets as we do in the operations on mathematical sets.
*
* It doesn't contains the duplicate elements
* */
fun main(args: Array<String>) {
    // simple immutable, fix sized set :
    val mySet: Set<Int> = mutableSetOf<Int>(21,32,54,243,2)

    for (i in mySet){
        println("$i")
    }
    println()

    // mutableSetOf in Kotlin
    val mySet2: MutableList<Int> = mutableListOf<Int>()
    mySet2.add(10)
    mySet2.add(30)
    mySet2.add(40)
    mySet2.add(100)

    // we can also remove the elements based on the value
    mySet2.remove(100)

    for (i in mySet2){
        println("$i")
    }

    // hashSetOf in Kotlin
    // hashSetOf returns the object of HashSet you can see below that mySet3 is of the type HashSet object
    // hashSetOf stores the element in random order
    val mySet3: HashSet<Int> = hashSetOf<Int>()
    mySet3.add(100)
    mySet3.add(200)
    mySet3.add(300)
    mySet3.add(400)

    for (i: Int in mySet3) {
        print("$i ")
    }
}