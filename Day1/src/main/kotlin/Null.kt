

fun main(args: Array<String>) {
    var aNotNullString :String ="abc";
     // aNotNullString= null;
    var aNullableString :String? = "Khanh";
    aNullableString= null;
    println("aNullableString is $aNullableString")

    //var len = if(aNullableString !=null ) aNullableString.length else -1
//    var len = aNullableString?.length ?: -1;
        var len=aNotNullString!!.length;
        println("Len = $len");

        val nullableList:List<Int?> = listOf(3,5,null,7);
        val intlist:List<Int> = nullableList.filterNotNull();
        println("inList = ${intlist}");
}