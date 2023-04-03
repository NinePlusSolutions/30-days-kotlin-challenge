package com.example.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.widget.Toast
import com.example.roomexample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var  db:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClick()
        db = AppDatabase.getData(this)
    }

    fun setOnClick(){
        binding.btnWriteData.setOnClickListener { writeData() }
        binding.btnReadData.setOnClickListener { readData() }
        binding.btnDeleteData.setOnClickListener { deleteData() }
        binding.btnUpdateData.setOnClickListener { updateData() }
    }
    fun writeData(){
        val firstName=binding.etFirstName.text.toString()
        val lastName=binding.etFirstName.text.toString()
        val rollNo=binding.etRollNo.text.toString()
        if (firstName.isNotEmpty() and lastName.isNotEmpty() and rollNo.isNotEmpty()) {
            val student=User(null,firstName,lastName,rollNo.toInt())
            GlobalScope.launch(Dispatchers.IO){
                db.userDao().insert(student)
            }
            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()
            binding.etRollNo.text.clear()
            Toast.makeText(this,"Successfuly",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Please enter data",Toast.LENGTH_SHORT).show()

        }
    }
    private suspend fun displayData(student:User){
        withContext(Dispatchers.Main){
            binding.tvFistname.text = student.firstName
            binding.tvLastname.text = student.lastName
            binding.tvrollNo.text = student.rollNo.toString()
        }
    }
    fun readData(){
        val rollNo=binding.etRollNoRead.text.toString()
        if (rollNo.isNotEmpty()){
            lateinit var student:User
            GlobalScope.launch {
                student=db.userDao().findByRoll(rollNo.toInt())
                displayData(student)
            }
        }
    }
    fun deleteData(){
        GlobalScope.launch {
            db.userDao().deleteAll()
        }
    }
    fun updateData(){
        val firstName=binding.etFirstName.text.toString()
        val lastName=binding.etFirstName.text.toString()
        val rollNo=binding.etRollNo.text.toString()
        if (firstName.isNotEmpty() and lastName.isNotEmpty() and rollNo.isNotEmpty()) {

            GlobalScope.launch(Dispatchers.IO){
                db.userDao().update(firstName,lastName,rollNo.toInt())
            }
            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()
            binding.etRollNo.text.clear()
            Toast.makeText(this,"Successfuly update",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Please enter data",Toast.LENGTH_SHORT).show()

        }
    }
}