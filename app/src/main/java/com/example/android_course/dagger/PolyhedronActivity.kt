package com.example.android_course.dagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.android_course.R
import com.example.android_course.dagger.domain.PolyhedronService
import com.example.android_course.dagger.tetra.TetrahedronActivity
import javax.inject.Inject

class PolyhedronActivity : AppCompatActivity() {

    @Inject lateinit var polyhedronService: PolyhedronService

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as PolyhedronApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)
        findViewById<Button>(R.id.next_button).setOnClickListener {
            startActivity(Intent(this, TetrahedronActivity::class.java))
        }
    }
}