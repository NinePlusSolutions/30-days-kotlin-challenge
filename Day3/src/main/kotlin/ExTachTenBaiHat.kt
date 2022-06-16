fun tachCach1(path: String):String{
    var arr=path.split("/")
    return arr[arr.size-1]
}
fun tachCach2(path: String):String{
    var vt=path.lastIndexOf("/")
    return path.substring(vt+1)
}
fun tachCach3(path: String):String{
    var vt1=path.lastIndexOf("/")
    var vt2=path.lastIndexOf(".")
    return path.substring(vt1+1,vt2)
}
fun main(args: Array<String>) {
    var path ="d:/nhac/nhacsen/longme.mp3"
    var ten1=tachCach1(path)
    println(ten1)
    var ten2=tachCach2(path)
    println(ten2)
    var ten3=tachCach3(path)
    println(ten3)
}