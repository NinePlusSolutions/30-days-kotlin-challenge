package com.example.example.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)
    @Update
    fun update(task: Task)
    @Query("DELETE FROM task_table")
    fun deleteaAll()

    @Query ("SELECT * FROM task_table ORDER BY time DESC")
    fun getALl():LiveData<List<Task>>
}