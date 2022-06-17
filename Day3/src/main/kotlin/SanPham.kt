class SanPham {
    constructor(){
        println("Đây là Secondary constructor ko đối số")
    }
    constructor(ma:Int,ten:String,dongia:Int){
        println("Đây là Secondary constructor cos 3  đối số")
        println("$ma - $ten - $dongia")
    }
}