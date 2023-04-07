package com.example.retrofitexample.Model

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
//            .header("Accept:application/json", "Content-Type:application/json")
            .header("Accept", "application/json")
            .addHeader("Authorization", "Bearer" + "791a10583cc9958159d24adf1c620377dbe2839cdbdc380609cce7c5e0a26e7a")
            .build()
        return  chain.proceed(newRequest)
    }

}