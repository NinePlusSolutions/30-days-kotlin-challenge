package com.example.exampleretrofituser

import com.example.exampleretrofituser.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @get:GET("users")
    val posts: Call<List<UserModel>>
}