package com.example.android_course.datastores

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import com.example.android_course.datastores.domain.PrefsDatastore
import com.example.android_course.datastores.domain.SimpleDatastore
import com.example.android_course.datastores.shitty_di.DatastoreInjectionActivityCallback

class ExampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(DatastoreInjectionActivityCallback(PrefsDatastore(this)))
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