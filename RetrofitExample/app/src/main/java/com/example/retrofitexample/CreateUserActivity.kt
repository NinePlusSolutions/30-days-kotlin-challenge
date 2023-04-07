package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexample.Model.User
import com.example.retrofitexample.databinding.ActivityCreateUserBinding

class CreateUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateUserBinding
    private lateinit var viewModel: CreateUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createUser()
        setOnClick()
    }


    fun setOnClick(){
        binding.btnCreate.setOnClickListener {
            createNewUser()
        }
    }
    fun createNewUser(){
        val user = User(null,binding.edtName.text.toString(), binding.edtEmail.text.toString(),"male","active")
//        Log.d("abc",binding.edtEmail.text.toString())
        viewModel.CreateUser(user)

    }

    fun createUser(){
        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
        viewModel.getCreateUser().observe(this, Observer <User>{
            if(it == null){
                Toast.makeText(this,"Fail Create new User....", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"Successfull Create new User....", Toast.LENGTH_SHORT).show()
                finish()
            }

        })
    }
}