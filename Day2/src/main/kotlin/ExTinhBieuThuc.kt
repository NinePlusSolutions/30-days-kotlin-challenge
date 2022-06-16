fun s(x:Double,n:Int):Double{
    var kq:Double = 0.0
    var mau:Double = 0.0
    for (i in 1..n){
        var tu=Math.pow(x,i*1.0)
        mau += i
        kq += (tu/mau)
    }
    return kq
}
fun main(args: Array<String>) {
    var kq1=s(2.0,3)
    println("Kết quả 1 = $kq1")
}