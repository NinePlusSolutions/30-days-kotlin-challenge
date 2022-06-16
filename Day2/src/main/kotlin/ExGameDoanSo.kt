import java.util.*

fun start(){
    var rd=Random()
    var soMay=rd.nextInt(5)
    var diem=6
    println("Hệ thống đã random 1 số [0,5]!")
    while (true){
        println("Mời bạn nhập số:")
        var soNguoi = readLine()?.toInt()
        if(soNguoi== null) break
        if(soNguoi==soMay){
            diem++
            println("Chúc mừng ! Bạn đã đoán đúng số máy = $soMay | điểm của bạn hiện tại = ${diem}")
        } else if(soNguoi!=soMay){
            diem--
            println("Bạn đoán sai ,điểm của bạn là : ${diem}")
        }
        if(diem==7){
            println("Congratulations! You win!")
            break
        } else if(diem==0){
            println("Game over")
            break
        }
    }
}
fun main(args: Array<String>) {
    while (true){
        start()
        println("Chơi nữa không chế ? (c/k):")
        var kq= readLine()
        if(kq?.compareTo("k",true) == 0)
            break
    }
    println("Cảm ơn bạn đã chơi")
}