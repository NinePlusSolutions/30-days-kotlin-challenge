package hello
class C{

}
class AA{//label = @A
    inner  class B {//label @B
        fun C.extendingFunction1(){
            val thisAtA = this@AA;
            println("thisAtA = ${thisAtA}")

            val thisAtB = this@B;
             println("thisAtB = ${thisAtB}")

            val thisAtExtendingFunction1 = this@extendingFunction1;
            println("thisAtExtendingFunction1 = $thisAtExtendingFunction1");

            val thisAtHere = this
            println("this AtHere = ${thisAtHere}")

            val noNameFunction = fun(){
                val thisAtNoname = this
                println("thisAtNoName = ${thisAtNoname}")
            }
            noNameFunction();

        }
        fun methodOfclassB(){
            var cObject = C();
            cObject.extendingFunction1();
        }
    }
}

fun main(args: Array<String>) {
    var objectA = AA();
    objectA.B().methodOfclassB();

}