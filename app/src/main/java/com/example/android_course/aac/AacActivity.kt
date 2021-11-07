package com.example.android_course.aac

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.android_course.databinding.ActivityAacBinding

class AacActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAacBinding

    private lateinit var sphericalPermanentConnectionListener: SphericalPermanentConnectionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAacBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.title.text = "LOL KEK TITLE"
        sphericalPermanentConnectionListener = SphericalPermanentConnectionListener(
            lifecycle = lifecycle,
            registryOwner = this
        ) {
            // do something
        }

        lifecycle.addObserver(sphericalPermanentConnectionListener)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}