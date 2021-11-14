package com.example.android_course.dagger

import android.app.Application
import com.example.android_course.dagger.di.ApplicationComponent
import com.example.android_course.dagger.di.DaggerApplicationComponent

class PolyhedronApplication: Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.factory().create(this)
}