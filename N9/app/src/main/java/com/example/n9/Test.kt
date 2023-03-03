package com.example.n9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import java.lang.reflect.Type

data class PhotoModel(
    var id: Int = 0,
    var path: String? = null,
)

class Test : AppCompatActivity() {

    var checkNull:String? = null //

    class MyList<T> {
        private val elements = mutableListOf<T>()
        fun add(element: T) {
            elements.add(element)
        }
        fun get(index: Int){
            Log.d("list", "${elements[index]}")
        }

        fun showAll(){
            Log.d("list","$elements")

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var x: Int? = null//x co the null
        toast(x.toString())// in ra null
        x = null
        toast(x.toString())//

        val list = MyList<String>()
        list.add("apple")
        list.add("banana")
        list.add("orange")
        list.add("lemon")
        list.showAll()
        list.get(3)
        val numbers = MyList<Int>()
        numbers.add(1)
        numbers.add(2)
        numbers.add(3)
        numbers.add(4)
        numbers.showAll()
        numbers.get(3)





        //Log.d("list", "")


//        list.showAll()
//        list.update()
//        list.showAll()

//        val numbers = MyList<Int>()
//        numbers.add(1)
//        numbers.add(2)
//        numbers.add(3)
//        numbers.add(4)
//        numbers.get(3)3


       // toast("onCreate")
    }

//    override fun onStart() {
//        super.onStart()
//        toast("onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        toast("onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        toast("onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        toast("onStop")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        toast("onRestart")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        toast("onDestroy")
//    }
//
    fun toast(state: String){
        Toast.makeText(this, state, Toast.LENGTH_SHORT).show()
        Log.d("Now: ", state)
    }

    fun main() {
        var a: String? = null
        if (a != null) {
            println(a.length)
        } else {
            println("a is null")
        }
    }
}

fun String.count(): Int{
    var count = 0
    val string = this.split("")
    for (i in string){
        count++
    }

    return count
}

