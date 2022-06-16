fun main(args: Array<String>) {
    var n:Int?
    println("Nhập số phần tử của mảng theo thứ tự tăng dần:")
    n = readLine()?.toInt()
    if(n==null ) return
    var M:IntArray = IntArray(n)
    print("Nhập M[0]=")
    M[0]= readLine()?.toInt()!!
    for (i in 1..M.size-1){
        print("Nhập M[$i]=")
        M[i]= readLine()?.toInt()!!
        if(M[i]>M[i-1])
            continue
        else
            println("Nhập phần tử của mảng theo thứ tự tăng dần:")
            print("Nhập M[$i]=")
            M[i]= readLine()?.toInt()!!
    }
    for (item in M)
        print("$item \t")
}