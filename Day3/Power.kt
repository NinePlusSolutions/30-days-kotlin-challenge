fun Power( a: Int, b: Int) {
    var tmp:Int = 1
    for(i in 1..b){
        tmp *= a
    }
    print(tmp)

}

fun main() {
    Power(2,5)
}