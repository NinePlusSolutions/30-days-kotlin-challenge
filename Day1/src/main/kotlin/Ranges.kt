/**
 * Ranges
 */
fun main(args: Array<String>) {
    for (i in 1..10){
        print("$i ,");
    }
    println("form 10 down to 1")
    for (i in 10 downTo 1){
        print("$i ,");
    }
    println("from 1 to 9")
    for (i in 1 until 10){
        print("$i ,");
    }
    var ints= listOf<Int>(10,20,30,40,50,60);
    if (30 !in ints){
        println("This is number exits in the list")
    } else {
        println("This is number  not exits in the list")
    }
    //step
    for (i in 0..20 step 2){
        print("$i ,")
    }
    println("dowto with step")
    for (i in 20 downTo 0 step 2){
        print("$i ,")
    }
    var fillerInts = (1..30 step 2);
    println("fillerInts details:");
    for (filleeInt in fillerInts){
        print("$filleeInt ,");
    }

}