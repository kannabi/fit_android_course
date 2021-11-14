package com.example.android_course.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_course.R
import com.example.android_course.dagger.domain.PolyhedronService
import javax.inject.Inject

class PolyhedronActivity : AppCompatActivity() {

    @Inject lateinit var polyhedronService: PolyhedronService

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as PolyhedronApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)
    }
}