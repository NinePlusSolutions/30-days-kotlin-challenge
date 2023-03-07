package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.model.User

class MainActivity : AppCompatActivity() {


    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<User>


    var  image : ArrayList<Int> = arrayListOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
        R.drawable.f,
        R.drawable.g,
        R.drawable.h,
        R.drawable.i,
        R.drawable.k
    )
    var username: ArrayList<String> = arrayListOf(
        "abc",
        "camtu",
        "van",
        "huong",
        "123",
        "ha",
        "hung",
        "nhi",
        "mien",
        "thuong"
    )
    var comment: ArrayList<String> = arrayListOf(
        "abc",
        "camtu",
        "van",
        "huong",
        "123",
        "ha",
        "hung",
        "nhi",
        "mien",
        "thuong"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newRecyclerView=findViewById(R.id.rcvDemo)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList= arrayListOf()
        getData()

    }

    private fun getData() {

        for (i in image.indices){
            var new=User(username[i],comment[i],image[i])
            newArrayList.add(new)
        }
        newRecyclerView.adapter=ListRowAdapter(newArrayList)
    }

}