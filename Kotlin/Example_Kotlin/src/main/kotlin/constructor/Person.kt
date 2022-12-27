package constructor

class Person (val _name: String, val _age:Int){
    //member variable
    var name: String
    var age: Int
    // Initializer Block
    init {
        this.name = _name
        this.age = _age
        println("Name = $name")
        println("Age = $age")
    }
}
class Person2{
    var name: String
    var age: Int

    init {
        println("Initializer Block")
    }
    //Secondary Constructor
    constructor( _name:String, _age:Int){
        this.age = _age
        this.name = _name
        println("Name: $name")
        println("Age: $age")
    }
}