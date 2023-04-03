package com.example.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.example.database.Task
import com.example.example.database.TaskDao
import com.example.example.database.TaskDatabase
import com.example.example.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application:Application):AndroidViewModel(application) {
    private val taskDao =  TaskDatabase.getDatabase(application).taskDao()
    private val repository : TaskRepository
    val getAll :LiveData<List<Task>>
    init {
        repository = TaskRepository(taskDao)
        getAll = repository.getALl()

    }
    fun insert(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(task)
        }
    }
    fun update(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.update(task)
        }
    }
    fun delete(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(task)
        }
    }
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }
}
