package com.example.recycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var studentAdapter: StudentAdapter? = null
    private var listStudent: ArrayList<Student>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setView()
        setData()
        setStudentAdapter()
    }

    private fun setData() {
        listStudent = ArrayList<Student>()
        for (i in 1..20) {
            (listStudent)?.add(Student("StudentName$i", 2000 + i % 2))
        }
    }

    private fun setView() {
        recyclerView = findViewById(R.id.rcvStudentList)
        val gridManager = GridLayoutManager(this, 2)
        gridManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if ((position + 1) % 3 * 2 == 0) {
                    2
                } else 1
            }
        }
        recyclerView!!.layoutManager = gridManager
    }

    private fun setStudentAdapter() {
        studentAdapter = StudentAdapter(listStudent!!, this)
        recyclerView!!.adapter = studentAdapter
    }
}