package com.example.retrofitexample.Model

data class UserList(val data:List<User>)

data class User(
    val id: String?,
    val name: String?,
    val email: String?,
    val gender: String?,
    val status: String?,


)
data class UserRespon(val code:Int?,val meta:String?,val data:User?)
