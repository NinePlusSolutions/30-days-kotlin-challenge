package com.example.example.repository

import androidx.lifecycle.LiveData
import com.example.example.database.Task
import com.example.example.database.TaskDao

class TaskRepository(var taskDao: TaskDao) {
    fun insert(task: Task) = taskDao.insert(task)
    fun delete(task: Task) = taskDao.delete(task)
    fun update(task: Task) = taskDao.update(task)
    fun deleteAll(){
        taskDao.deleteaAll()
    }
    fun getALl() : LiveData<List<Task>> = taskDao.getALl()
}