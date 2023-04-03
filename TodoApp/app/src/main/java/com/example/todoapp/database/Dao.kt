package com.example.todoapp.database
import androidx.room.*

import androidx.room.Dao
import com.example.todoapp.TaskInfo

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertTask(entity: Entity)

    @Update
     fun updateTask(entity: Entity)

    @Delete
     fun deleteTask(entity: Entity)

    @Query("Delete from todo")
    fun deleteAll()

    @Query("Select * from todo")
     fun getTasks():List<TaskInfo>
}