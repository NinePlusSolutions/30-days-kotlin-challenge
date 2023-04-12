package com.example.dagger2

import android.app.Application
import com.example.dagger2.di.DaggerRetroComponent
import com.example.dagger2.di.RetroComponent
import com.example.dagger2.di.RetroModel
import dagger.Component

// Definition of the Application graph
//@Component
//interface ApplicationComponent {
//    fun inject(activity: LoginActivity)
//}

class MyApplication : Application() {
    private lateinit var retroComponent: RetroComponent
//    val appComponent = ApplicationComponent.create()

    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.create()
    }
    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}