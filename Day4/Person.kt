import java.net.Inet4Address

class Person(var name: String, var phone:String, var address: String,var age:Int) {
    fun moveAddress(address: String){
        this.address=address
    }
    fun changePhone(phone: String){
        this.phone=phone
    }
    fun displayInfo():String{
        return "Name:$name,phone:$phone,address:$address,age:$age"
    }
}