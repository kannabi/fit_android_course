package com.example.android_course.datastores

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.android_course.datastores.domain.AppDatabase
import com.example.android_course.datastores.domain.DatabaseDatastore
import com.example.android_course.datastores.domain.PrefsDatastore
import com.example.android_course.datastores.domain.SimpleDatastore
import com.example.android_course.datastores.shitty_di.DatastoreInjectionActivityCallback

class ExampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "school-database").build()
            .let(::DatabaseDatastore)
            .let(::DatastoreInjectionActivityCallback)
            .let(::registerActivityLifecycleCallbacks)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }
}