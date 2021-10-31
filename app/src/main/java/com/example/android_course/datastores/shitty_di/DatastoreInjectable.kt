package com.example.android_course.datastores.shitty_di

import com.example.android_course.datastores.domain.Datastore
import com.example.android_course.datastores.domain.StudentDatastore

interface DatastoreInjectable {
    fun injectDatastore(datastore: Datastore)
}

interface StudentDatastoreInjectable {
    fun injectDatasore(datastore: StudentDatastore)
}