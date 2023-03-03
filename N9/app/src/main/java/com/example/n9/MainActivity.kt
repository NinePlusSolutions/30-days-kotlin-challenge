package com.example.n9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var text : Boolean = false
//        text.isTrue()
        var text = mutableListOf<String>("a", "b")
        text.swap()

    }
}
//fun Boolean?.isTrue() = this == true
//
//fun Boolean?.isNotTrue() = !this.isTrue()
//
//inline fun <reified T> List<T>?.equalsExt(listCompare: MutableList<T>?) = this?.size == listCompare?.size &&
//        this?.containsAll(listCompare ?: mutableListOf()) == true
fun MutableList<String>.swap(){
    var b = 0
    val temp = this[0]
    this[0] = this[1]
    this[1] = temp
    println(this)
}
