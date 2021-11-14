package com.example.android_course.dagger.di

import com.example.android_course.dagger.PolyhedronActivity
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent {
    fun inject(activity: PolyhedronActivity)
}