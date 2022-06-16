fun giaiPTB2(a:Double , b:Double , c:Double):String
{
    if(a==0.0){
        //bx+c=0
        if(b==0.0 && c==0.0)
            return "Vô số nghiệm"
        if(b==0.0 && c!=0.0)
            return "Vô nghiệm"
        var x=-c/b
        return "No="+x
    }
    else{
        var delta = b*b-4*a*c
        if(delta<0)
            return "Vô nghiệm"
        if(delta==0.0){
            var x=b/(2*a)
            return "No kép x1=x2"+x
        }
        var x1=(-b-Math.sqrt(delta))/(2*a)
        var x2=(-b+Math.sqrt(delta))/(2*a)
        return "x1="+x1+"||"+"x2="+x2
    }
}
fun main(args: Array<String>) {
    var a:Double?
    var b:Double?
    var c:Double?
    println("Nhập hệ số a:")
    a = readLine()?.toDouble()
    println("Nhập hệ số b:")
    b = readLine()?.toDouble()
    println("Nhập hệ số c:")
    c = readLine()?.toDouble()
    if (a==null || b== null || c==null) return
   var kq = giaiPTB2(a,b,c)
    println(kq)

}