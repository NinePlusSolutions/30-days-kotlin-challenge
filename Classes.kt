fun main(args: Array<String>) {
    class Sailor(var rank:String, var lastName: String){
        var fullName: String
            get() = "$rank $lastName"
            set(value){
                println("set")
                val (firstWord, remainder) = value.split(" ", limit = 2)
                rank = firstWord
                lastName = remainder
            }
    }

    val s = Sailor("2","Phan")
    s.fullName= "Phan Minh Phu"
    println(s.fullName)


}