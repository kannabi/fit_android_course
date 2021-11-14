package com.example.android_course.dagger.di

import com.example.android_course.dagger.PolyhedronActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent {
    fun inject(activity: PolyhedronActivity)
}