fun main(args :Array<String>){
    var ints :Array<Int> = arrayOf(10,20,30,40,50,60);
    for (eachInt in ints){
        if (eachInt == 30) {
           // break;
            continue;
        }
        println("each integer = $eachInt");
    }
    labelOne@ for (i in 1 ..100){
      labelTwo@  for (j in 1..100){
            if (i == 20 && j==20){
                break@labelTwo;
            }
          println("i = $i j= $j");
        }
    }
    fun printIntegerList(intNumbers: Array<Int>){
        intNumbers.forEach(fun(item :Int){
            if (item == 30 ) return ;
            println("item = $item");
        })
    }
    printIntegerList(ints);
}
