class FibonacciNumberSteps(val term:Int){
    var t1: Int = 0
    var t2: Int = 1
    var nextTerm: Int = t1 + t2

    fun listedFinobacci(){
        print("Fibonacci Series: $t1, $t2, ")
        for ( i in 3..term){
            print("$nextTerm, ")
            t1 = t2
            t2 = nextTerm
            nextTerm = t1 + t2
        }
    }
}
fun main() {
    val tmp= FibonacciNumberSteps(10)
    tmp.listedFinobacci()
}