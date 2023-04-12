package com.example.dagger2.di

import com.example.dagger2.model.RecyclerData
import com.example.dagger2.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    fun getData(@Query("q")query: String):Call<RecyclerList>?
}