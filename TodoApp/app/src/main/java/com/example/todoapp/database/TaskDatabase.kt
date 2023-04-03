package com.example.todoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class],version=1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun dao():Dao

    companion object{
        @Volatile
        private var  INSTANCE : TaskDatabase? =null
        fun getDatabase(context: Context):TaskDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance ==  null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "Todo_App"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}