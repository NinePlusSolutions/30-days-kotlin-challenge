fun main() {
    var person=Person(name = "Bui Dang Duong", phone = "01234566789", address = "da nang", age = 22)
    println(person.displayInfo())
///LET
//    person.let {
//        user ->
//        println(user.displayInfo())
//        user.moveAddress("hcm")
//        user.changePhone("0900909090")
//        println(user.displayInfo())
//
//    }
//       val numbers : MutableList<String> = mutableListOf("one","tow","three","four","five","six")
//    numbers.map {
//        item ->
//        item.length
//    }.filter {
//        it > 3
//    }.let {
//        println(it)
//    }

      ///RUN
//    person.run {
//
//        println(displayInfo())
//        moveAddress("hcm")
//        changePhone("0900909090")
//        println(displayInfo())
//
//    }
//    val numbers : MutableList<String> = mutableListOf("one","tow","three","four","five","six")
//    numbers.map {
//            item ->
//        item.length
//    }.filter {
//        it > 3
//    }.run {
//        println(this)
//    }
    ///WITH
//    with(person){
//        println(displayInfo())
//        moveAddress("ha tinh")
//        changePhone("0000000")
//        println(displayInfo())
//    }
//    val numbers : MutableList<String> = mutableListOf("one","tow","three","four","five","six")
//    with(numbers.map {
//        it.length
//    }.filter {
//        it>3
//    }
//    ){
//        println(this)
//    }
    //APLLY
//    val person3=Person(name = "duong bui", address = "ha nooi", phone = "090806786", age = 12)
//        .apply {
//            println(this.displayInfo())
//            name="duong bui dang"
//            address="thanh hoa"
//            phone="9999999"
//            age=90
//        }
//    println(person3.displayInfo())
    ///ALSO
    val person4:Person=Person(
        name = "duong",
        address = "hcm",
        phone = "0777777",
        age = 8
    ).also {
        person ->
        println(person.displayInfo())
        person.name="duonght"
        person.address="lao cai"
        person.phone="0000000"
        person.age=9
    }
    println(person4.displayInfo())
}