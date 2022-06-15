fun main(){
    val list = mutableListOf ( 2 , 3 , 5 , 6 , 7 )
    list [ 2 ] = 100  // works now
    println (list [ 2 ]) // 100
    println(list)
    list.add (index = 3 , element = 500 )
    println(list)
    println (list [ 3 ]) // 500
    list.remove ( 7 )
    println (list) // [2, 3, 100, 500, 6]
    list.removeAt ( 0 )
    println (list)
}