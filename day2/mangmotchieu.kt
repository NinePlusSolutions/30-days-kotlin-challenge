fun main(args: Array<String>) {
    var M :IntArray= IntArray(10)
    M [0]=40
    M[1]=50
    M[9]=-30
    println("gia tri la:")
    for (i in M.indices){
        println("${M[i]}")
    }
    println("cac so am trong mang la ")
    var dsam=M.filter { x->x<0 }
    for (x in dsam)
    {
        println("$x\t")
    }



}