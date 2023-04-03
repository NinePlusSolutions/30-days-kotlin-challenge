package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.database.database
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener {
            var intent =Intent(this,CreateCardActivity::class.java)
            startActivity(intent)
        }
        rcvTask.adapter = Adapter(database.getAllData())
        rcvTask.layoutManager=LinearLayoutManager(this)
        btnDeleteAll.setOnClickListener {
            database.deleteAll()
        }
    }
}