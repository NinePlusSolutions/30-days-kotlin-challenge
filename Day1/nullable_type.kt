fun main()
{
    var name: String? = "Jonny" // Safe cast operator ?
    // length1 contains name's length if name isn't null
    var length1: Int? = name?.length

    val length3 = name?.length ?: return
    println(length3)
    println(length1)
}
