fun main()
{
    val book = Book("Java", 1000)
    println(book)
    book.name = "Kotlin" 
    book.price = 1200
    //because var can be change, so name change frome Java to Kotlin
    println(book)
    // because val can't be change
    // if you uncomment under line, error appear "error: val cannot be reassigned"
    // book = Book("JS", 800)
}
//declare class for change
data class Book(var name : String = "",
                var price : Int = 0)