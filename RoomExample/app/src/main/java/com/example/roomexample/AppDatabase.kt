package com.example.roomexample

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Dao
@Database(entities = [User :: class], version = 1)
abstract class AppDatabase :RoomDatabase(){

    abstract fun userDao(): UserDao
    companion object{

        @Volatile
        private var  instance : AppDatabase? =null
        fun getData(context: Context):AppDatabase{
             val temp=  instance
            if(temp != null){
                return temp
            }
            synchronized(this){
                var INSTANCE=Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "App_name"
                ).build()
                instance=INSTANCE
                return INSTANCE
            }
        }
    }
}