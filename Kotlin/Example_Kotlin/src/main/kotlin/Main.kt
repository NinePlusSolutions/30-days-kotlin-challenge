import Class.innerClass
import Class.nestedClass
import Class.Human
import constructor.Person
import constructor.Person2
import abstractClass.Employee
import extension.Alien
import extension.Temperature
import extension.addMySkills
import extension.fahrenheit
import `object`.myClass


//
typealias User = Triple<String, String, Int>
fun userInfo(): User{
    return Triple("Zara","Ali", 21)
}
fun main(){

    for ( num in 1..10 step 3){
        println(num)
    }
    //call nested class
    val objec = nestedClass.Nested()
    println(objec.foo())

    //call inner class
    val objects =  innerClass().Inner()
    println(objects.foo())
    println(objects.sum())

    //Anonymous inner class
    var pro: Human = object:Human{ //Anonymous inner class
        override fun think(){ // ovrriding the think menthod in Interface
            println("I am an example of anonymous inner class")
        }
    }
    pro.think()

    //call typeAlias
    var objj = userInfo()
    println(objj)

    //higher-order-functions
    val result = calculate(4,6, ::sum)
    println(result)
    var func = opeation()
    println(func(4))
    //lamdas - function
    val upperCase = {str: String -> str.uppercase()}
    println(upperCase("võ anh nguyên"))

    // object
    val objMyClass = myClass() // Create object objMyClass of MyClass class
    objMyClass.printMe() // Call a member function using object

    //Constructor
    var person = Person("Nguyen",22)
    var person2 = Person2("Quân",25)

    //abstractClass
    val employee = Employee("Zara")
    var age : Int

    employee.setPersonAge(20)

    age = employee.getPersonAge()

    employee.getPersonName()
    println("Age = $age")
    //Interface
    val objInter = InterfaceImp()
    println("My Variable Value is = ${objInter.myVar}")
    println("Calling hello(): ")
    objInter.hello()

    print("Message for the website---")
    println(objInter.absMethod())

    //Extension
    var a1 = Alien()
    a1.skills = "Java"

    var a2 = Alien()
    a2.skills = "SQL"

    var a3 = Alien()
    a3.skills = a1.addMySkills(a2)
    a3.printMySkills()
    //extension properties
    val t = Temperature(40f)
    println(t.fahrenheit)

    t.fahrenheit = 85f
    println(t.celsius)

    var objet=genericsExample<String>("JAVA")
    var objet1=genericsExample<Int>(10)

}

fun sum(a: Int, b:Int) = a + b
fun calculate(a: Int, b:Int, operation:(Int,Int) -> Int): Int{
    return operation(a,b)
}
fun square(x: Int) = x*x
fun opeation(): (Int) -> Int{
    return ::square
}
class genericsExample<T>(input:T){
    init{
        println("I am getting called with the value "+input)
    }
}
