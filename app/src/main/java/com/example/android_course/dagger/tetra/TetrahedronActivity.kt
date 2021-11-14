package com.example.android_course.dagger.tetra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.android_course.R
import com.example.android_course.dagger.PolyhedronApplication
import javax.inject.Inject

class TetrahedronActivity : AppCompatActivity() {
    lateinit var tetraComponent: TetraComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        tetraComponent =
            (application as PolyhedronApplication).appComponent.tetraComponent().create()
        tetraComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tetrahdron)
        findViewById<FragmentContainerView>(R.id.fragment_container)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, TetraFirstFragment.getInstance(), null)
            .commit()
    }
}