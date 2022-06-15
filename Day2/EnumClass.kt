enum class Taste {
    SWEET, SOUR, SALTY, BITTER, UMAMI
}

val vinegarTaste: Taste = Taste.UMAMI
// Iterating through an enum class
fun main(args: Array<String>) {
    for ( flavor in Taste.values()){
        println("Taste: ${flavor.ordinal}: ${flavor.name}")
    }
}