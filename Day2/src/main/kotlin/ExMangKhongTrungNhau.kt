import java.util.*

fun main(args: Array<String>) {
    var mang:IntArray = IntArray(10)
    var rand = Random()
    for (i in mang.indices) {
        mang[i] = rand.nextInt(100)
    }
    var dsLoc = mang.filter { x->
        var dem = 0
        for(i in mang.indices)
        {
            if(x == mang[i])
                dem++
        }
        dem==1
    }
    for (item in dsLoc)
        print("$item \t")
}