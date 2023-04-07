package com.example.retrofitexample.Model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Database {
    companion object{
        val baseURL= "https://gorest.co.in/"
        val client = OkHttpClient.Builder()
            .addInterceptor(MyInterceptor())
            .build()
        fun getRetroInstance():Retrofit{

          return  Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}