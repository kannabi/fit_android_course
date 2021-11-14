package com.example.android_course.dagger.di

import com.example.android_course.dagger.PolyhedronActivity
import dagger.Component

@Component
interface ApplicationComponent {
    fun inject(activity: PolyhedronActivity)
}