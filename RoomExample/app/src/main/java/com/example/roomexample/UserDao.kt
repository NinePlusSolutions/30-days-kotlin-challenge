package com.example.roomexample

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM User ")
    fun getAll():List<User>     //get toàn bộ user có trong bảng user
    @Query("SELECT * FROM User WHERE roll_no  LIKE :roll LIMIT 1")
     fun findByRoll(roll: Int): User
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)
    @Delete
    fun delete(user: User)
    @Query("DELETE FROM User")
    fun deleteAll()
    @Query("UPDATE User SET first_name=:firstname,last_name=:lastname WHERE roll_no LIKE:roll ")
    fun update(firstname:String,lastname:String,roll:Int)
}
