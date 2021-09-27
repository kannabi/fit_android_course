package com.example.android_course.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.android_course.R

class MainActivity : AppCompatActivity(), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_0)?.setOnClickListener {
            replaceFragment(PAGE_0)
        }

        findViewById<Button>(R.id.button_1)?.setOnClickListener {
            replaceFragment(PAGE_1)
        }
        if (savedInstanceState == null) {
            replaceFragment(PAGE_0)
        }

    }

    private lateinit var currentTag: String
    private var counter: Int = 0

    override fun next() {
//        val fragment = DetailsFragment.getInstance("tag")
//        supportFragmentManager
//            .beginTransaction()
//            .replace(
//                R.id.fragment_container,
//                fragment,
//                DetailsFragment::class.qualifiedName
//            )
//            .setReorderingAllowed(true)
//            .addToBackStack(tag)
//            .commit()
    }

    private fun replaceFragment(tag: String) {
        currentTag = tag
        var fragment = supportFragmentManager.findFragmentByTag(tag)

        val needAddToBackStack: Boolean
        if (fragment == null) {
            fragment = DetailsFragment.getInstance(tag)
            needAddToBackStack = true
        } else {
            needAddToBackStack = false
        }

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                fragment,
                tag
            )
            .setReorderingAllowed(true)
            .apply {
                if (needAddToBackStack) {
                    addToBackStack(tag)
                }
            }
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val PAGE_0 = "PAGE_0"
        private const val PAGE_1 = "PAGE_1"
    }

}