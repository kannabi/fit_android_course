package com.example.android_course.datastores.shitty_di

import com.example.android_course.datastores.domain.Datastore

interface DatastoreInjectable {
    fun injectDatastore(datastore: Datastore)
}