fun main(args: Array<String>) {
    // ImmutableList()
    MutableList()


}

fun ImmutableList() {
    var ds: List<Int> = listOf(6, 7, 4, 6, -20)
    for (i in ds.indices)
        println("${ds[i]}\t")
    var dschan = ds.filter { x -> x % 2 == 0 }
    for (i in dschan.indices)
        println("danh sach chan la ${dschan[i]}\t")
}

fun MutableList() {
    var ds1: MutableList<Int> = mutableListOf()
    //them phan tu vao mang
    ds1.add(10)
    ds1.add(2)
    ds1.addAll(mutableListOf(2, 4, 5))
//    for (i in ds1){
//        //println("${ds1[i]}\t")
    //sap xep cac phan tu theo chieu tang dan trong mang
    ds1.sort()
    for (i in ds1) {
        println("$i")
//    //sap xep cac phan tu giam dan trong mang
//
////    ds1.sortDescending()
//            println("sap xeo giam dan:\n")
////     for (i in ds1){
////         println("$i")
////     }
//    }

    }
}
