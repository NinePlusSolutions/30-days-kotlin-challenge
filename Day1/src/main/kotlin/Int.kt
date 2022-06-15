
fun main(args:Array<String>) {
    println("Hello World");
    val x : Double = 3.66;
    //x = 5.5;
    println("x = $x");
    val creditCardNumber = 1234_456_789_1011L;
    println("creditCardNumber= $creditCardNumber");
    val aNulllableInt : Int?;
    aNulllableInt=20;
    println("aNulllableInt = $aNulllableInt");
    // Explicit Conversions
    var anInt : Int? =123;
    val anLong : Long? =anInt?.toLong();
    println("aLong = $anLong");

    var aConvertedFloat :Float = "12345".toFloat();
    println("aConvertedFloat = $aConvertedFloat");
    var a:Double = 0.0;
    var b:Double = -0.0;
    if (a==b){
        println("a is equal to b");
    };
    var z:Double = 10.0;
    var a1:Double = z;
    var b1:Double = z;
    if (a1===b1){
        println("a1 is identical to b1");
    }
}