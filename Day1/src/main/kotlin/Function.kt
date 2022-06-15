package hello

fun main(args : Array<String>){
    fun addTwoInts(x : Int, y :Int): Int {
        return x + y
    }
   //fun addTwoInts(x : Int, y :Int): Int = x+y;
    println("Add two number = ${addTwoInts(8,9)}");
    //fun areaOfRectangle(width: Double,height:Double = 123.0) :Double
    fun areaOfRectangle(width: Double,height:Double = 123.0) :Double{
        return width * height;
    }
    println("AreaOfRectangle = ${areaOfRectangle(10.0,20.0)}");
    println("AreaOfRectangle = ${areaOfRectangle(10.0)}");
    //fun great(personName: String?)
    fun great(personName: String?): Unit{
        if (personName != null) {
            println("Hello $personName !")
        } else {
            println("hi there ")
        }
    }
    great("Le Ngoc Khanh");
    //Varargs = variable number of argument
    fun functionA(vararg intParams:Int){
        for (eachParams in intParams){
            println("each Param : $eachParams")
        }
    }
    functionA(1,2,9,8);
    println("relaxing");
    functionA(10,11);
    //Infix notation
    infix fun Int.plus(x:Int):Int{
        return this + x;
    }
    println("3 + 2 = ${3 plus 2}");
    tailrec fun factorial(n:Long =1):Long{
        if (n ==1L){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
    println("fatorial of 5 is ${factorial(1000)}")
}