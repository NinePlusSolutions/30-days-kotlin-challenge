fun Triangles( n: Int) {
    for(i in 0 until  n){
        // can le
        for(j in 0 until n-i){
            print(" ")
        }
        // in so *
        for(k in 0 until i){
            print("* ")
        }
        println("")
    }

}

fun main() {
    Triangles(10)
}