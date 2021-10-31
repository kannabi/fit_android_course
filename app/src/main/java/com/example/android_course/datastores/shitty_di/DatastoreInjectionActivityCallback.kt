package com.example.android_course.datastores.shitty_di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.android_course.datastores.domain.Datastore
import com.example.android_course.datastores.domain.StudentDatastore

class DatastoreInjectionActivityCallback(
    private val datastore: StudentDatastore
): Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        (activity as? StudentDatastoreInjectable)?.injectDatasore(datastore)
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }
}