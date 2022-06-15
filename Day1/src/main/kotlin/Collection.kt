/**
 * @author Khanh
 * Collection types(List , Map , Set)
 */

fun main(args: Array<String>) {
    val number:MutableList<Int> = mutableListOf(1,2,3);
    val readOnlyNumbers:List<Int> = number;
    println(number);
    number.add(4);
    println(number);
    println("read only numbers = $readOnlyNumbers");
   //readOnlyNumbers.add();
    val strings = mutableSetOf("a","b","c","d");
    if (strings.contains("g")){
        println("this set contains g");
    } else {
        println("this set not contains g");
    }
    println(strings);
    println(strings.sortedDescending());
    //take snapshot of a collection at a particular poin in time
    val floatMutableList :MutableList<Float> = mutableListOf(1.0F,2.0F,3.0F);
    val bakupfloatlist:List<Float> = floatMutableList.toList();
    floatMutableList.add(4.0F);
    println("floatmutablelist = $floatMutableList");
    println("bakupfloatlist = $bakupfloatlist");

    println("fist element of float mutable list is = ${floatMutableList.first()}");
    println("last element of float mutable list is = ${floatMutableList.last()}");

    println("fitter of floatMutableList with value >2.0 is = ${floatMutableList.filter { item -> item >2.0F }}");

    val listWithNullElement :MutableList<Int ?> = mutableListOf(1,2,null,3,4);
    println("list = ${listWithNullElement}")

   // listWithNullElement.requireNoNulls();
    var mutableHashMap = mutableMapOf<String,Int>("x" to 1, "y" to 2);
    //mutableHashMap["x"] = 100;
    mutableHashMap.set("x",100);
    println("mutableHashMap = $mutableHashMap");
}
