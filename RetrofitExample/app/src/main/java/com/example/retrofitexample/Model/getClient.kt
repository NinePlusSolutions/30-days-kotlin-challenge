package com.example.retrofitexample.Model

import retrofit2.Call
import retrofit2.http.*

interface getClient {
    //https://gorest.co.in/public/v2/users
    @GET("public/v2/users/")
    fun getUserList(): Call<List<User>>

    @GET("public/v2/users/")
    fun seacherUser(@Query("name") searchText:String  ): Call<List<User>>

    @POST("public/v2/users/")
    fun createUser(@Body params: User): Call<User>
}