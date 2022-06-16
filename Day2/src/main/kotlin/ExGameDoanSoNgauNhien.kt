import java.util.*

fun choi(){
    var rd =Random()
    var soMay=rd.nextInt(100)
    var soLanDoan = 0
    println("Hệ thống đã ramdon 1 số trong đoạn [0..100]!")
    while (true){
        println("Mời bạn nhập số:")
        var soNguoi = readLine()?.toInt()
        if(soNguoi== null) break
        soLanDoan++
        println("Bạn đoán lần thứ $soLanDoan")
        if(soNguoi==soMay){
            println("Chúc mừng ! Bạn đã đoán đúng số máy = $soMay")
            break
        } else if(soNguoi>soMay){
            println("Bạn đoán sai,số máy nhỏ hơn số của bạn")
        } else if(soNguoi<soMay){
            println("Bạn đoán sai,số máy lớn hơn số của bạn")
        }
        if(soLanDoan>7){
            println("Game Over")
            break
        }
    }
}
fun main(args: Array<String>) {
    while (true){
        choi()
        println("Chơi nữa không chế ? (c/k):")
        var kq= readLine()
        if(kq?.compareTo("k",true) == 0)
            break
    }
    println("Cảm ơn bạn đã chơi")
}