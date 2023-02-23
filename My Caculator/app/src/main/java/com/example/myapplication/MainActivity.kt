package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ví dụ về khai báo đầy đủ
        var demo: String="fullname"
        //ví dụ về khai báo k có kiểu dữ liệu
        var ex="demo"

        //hằng số


        var abc = mutableListOf<Int>(1,2)

//        swap(abc,1,2);
        Log.i("hello",abc.toString());

//        fun <T>swap(list: MutableList<T>,i:Int,i2:Int){
//            val tmp=list[i]
//            list[i]=list[i2]
//            list[i2]=tmp
//        }
    fun MutableList<String>.swap(firstIndex: Int, changeIndex: Int){
        val temp = this[firstIndex]
        this[firstIndex] = this[changeIndex]
        this[changeIndex] = temp
    Log.d("Result", "$this")

    }


    fun swapInList(list: MutableList<String>){
        val dataChange = list[0]
        list[0] = list[1]
        list[1] = dataChange
        println(list)
    }
}
//fun <T> swap(list:MutableList<T>,index1:Int,index2:Int){
//    val tmp=list[index1]
//    list[index1]=list[index2]
//    list[index2]=tmp

}