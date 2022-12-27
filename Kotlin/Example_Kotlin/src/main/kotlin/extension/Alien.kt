package extension

class Alien {
    var skills: String = "null"
    fun printMySkills(){
        println(skills)
    }
}

fun Alien.addMySkills(a: Alien):String{
    var a4 = Alien()
    a4.skills = this.skills + " " + a.skills
    return a4.skills
}