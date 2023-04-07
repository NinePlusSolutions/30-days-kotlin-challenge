package com.example.retrofitexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.Model.Database
import com.example.retrofitexample.Model.User
import com.example.retrofitexample.Model.getClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CreateUserViewModel:ViewModel(){
    lateinit var createUserData: MutableLiveData<User>
    init {
        createUserData = MutableLiveData()
    }
    fun getCreateUser():MutableLiveData<User>{
        return  createUserData
    }
    fun CreateUser(user: User){
        val retrofitInstance = Database.getRetroInstance().create(getClient::class.java)
        val call = retrofitInstance.createUser(user)
        call.enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    createUserData.postValue(response.body())
                }else{
                    createUserData.postValue(null)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                createUserData.postValue(null)
            }

        })
    }
}