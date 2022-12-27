package com.example.exampleretrofit

import com.example.exampleretrofit.model.AlbumItem
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @get:GET("photos")
    val posts: Call<List<AlbumItem>>
}