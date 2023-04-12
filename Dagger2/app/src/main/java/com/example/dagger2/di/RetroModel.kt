package com.example.dagger2.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetroModel {
    val baseURL = "https://api.github.com/search/" //repositories?q=newyork

    @Singleton
    @Provides
    fun getRetroService(retrofit: Retrofit): RetroService {
        return retrofit.create(RetroService::class.java)
    }

    @Singleton //sử dụng để chỉ định rằng chỉ có một instance của một
    // đối tượng được tạo trong suốt vòng đời của ứng dụng.
    @Provides  //sẽ tạo ra một đối tượng (object) và trả về nó cho Dagger 2 để inject vào các class khác.
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}