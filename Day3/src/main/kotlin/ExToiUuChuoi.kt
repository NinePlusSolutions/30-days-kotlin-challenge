fun toiuu(s:String):String{
    var sTam = s.trim()
    var dsWord=sTam.split(" ")
    var sToiUu=""
    for (word in dsWord){
        if(word.length>0)
        {
            var wordMoi=word.toLowerCase()
            wordMoi=wordMoi.replaceFirst(wordMoi[0]+"",(wordMoi[0]+"").toUpperCase())
            sToiUu+=wordMoi+" "
        }
    }
    return sToiUu.trim()
}
fun main(args: Array<String>) {
    var ten="  Lê    nGọc       Khánh"
    var ten2 = toiuu(ten)
    println(ten2)
}