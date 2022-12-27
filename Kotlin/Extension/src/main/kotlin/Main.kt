fun main(args: Array<String>) {
    val o = Student()
    println("The student has passed: ${o.isScholar(20)}")

    val str1 = "Hello"
    val str2 = "World"
    val str3 = "Hey"

    println(str3.add(str1,str2))

    val x = 10
    val y = 20
    println("The greater number is ${x.findGreater(y)}")
}
class Student{
    fun isPassed(mask: Int):Boolean{
        return  mask > 30
    }
}
fun Student.isScholar(mask: Int): Boolean{
    return mask > 50
}
fun String.add(s1:String, s2: String): String{
    return this+s1+s2;
}
fun Int.findGreater(other: Int): Int{
    return if(this > other){
        this
    } else {
        other
    }
}