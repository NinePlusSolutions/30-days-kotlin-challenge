package com.example.test_duration_4h

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<UserModel>
    private lateinit var textViewUsername: Array<String>
    private lateinit var textViewLocation: Array<String>
    private lateinit var textViewTime: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewUsername = arrayOf("JackBenTre", "Tommy", "Thomas", "John", "Soda")
        textViewLocation = arrayOf("@VietNam", "California", "Japan", "China", "ThaiLand")
        textViewTime = arrayOf("5h ago", "15m ago", "6d ago", "Just a few sec")

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()
    }

    private fun getUserData() {

        for (i in textViewUsername.indices){

            val users = UserModel(textViewUsername[i], textViewLocation[i], textViewTime[i])
            newArrayList.add(users)
        }

        newRecyclerView.adapter = Adapter(newArrayList)
    }
}