package com.example.android_course.datastores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_course.R
import com.example.android_course.datastores.domain.StudentDatastore
import com.example.android_course.datastores.shitty_di.StudentDatastoreInjectable

class StudentActivity : AppCompatActivity(), StudentDatastoreInjectable {

    private lateinit var studentDatastore: StudentDatastore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
    }

    override fun injectDatasore(datastore: StudentDatastore) {
        studentDatastore = datastore
    }
}