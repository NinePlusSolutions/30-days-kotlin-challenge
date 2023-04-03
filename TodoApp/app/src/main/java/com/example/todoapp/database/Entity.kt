package com.example.todoapp.database

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "todo")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title:String,
    var priority:String
)
