package com.example.recycleview

class Student(private var mName: String, var birthYear: Int) {

    fun getmName(): String {
        return mName
    }

    fun setmName(mName: String) {
        this.mName = mName
    }
}
