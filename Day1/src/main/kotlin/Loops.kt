package hello

fun main(args : Array<String>) {
    //if clause
    var a:Double = 6.2;
    var b:Double = 5.2;
    if (a>=b){
        println("a is larger then equal b");
    } else {
        println("a is smaller then equal b");
    };
    var aString = if (a>=b) "larger" else "smaller";
    println("aString = $aString");
    //"when" expression
    var c:Char = 'a';
    var stringResult :String = when(c){
        'a' ->"Fist character of the alphabet";
        'z' ->"Last character of the alphabet";
        else ->"other character";
    }
    println("stringResul = $stringResult");
    //User "when" as a function
    fun checkNumber(inputNumber : Int) =when (inputNumber){
        0 ->{
            println("do some thing ... ");
            println("this is zero");
        }
        1,2 ->{
            println("one or two");
        }
        in 3..10 -> println("a few , several")
        else -> println("many");
    }
    checkNumber(9 );
    // for loop
    val intNumbers:Array<Int> = arrayOf(11,22,43,55);
    println("for loop");
    for (intNumber in intNumbers){
        println("intNumber = $intNumber");
    }
    //using indices
    println("using indices");
    for (index in intNumbers.indices){
        println("Value at index = $index is ${intNumbers[index]}");
    }
    //using index , value pair
    println("using index , value pair");
    for ((index,value) in intNumbers.withIndex()){
        println("value at index = $index is $value");
    }
}