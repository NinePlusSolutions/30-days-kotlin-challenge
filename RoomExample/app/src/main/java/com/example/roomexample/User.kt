package com.example.roomexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int?,
    @ColumnInfo(name = "first_name") val firstName:String?,
    @ColumnInfo(name = "last_name") val lastName:String?,
    @ColumnInfo(name = "roll_no") val rollNo:Int?
)
