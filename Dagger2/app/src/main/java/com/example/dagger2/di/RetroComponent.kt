package com.example.dagger2.di

import com.example.dagger2.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RetroModel::class])
interface RetroComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
}