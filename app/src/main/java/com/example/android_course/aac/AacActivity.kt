package com.example.android_course.aac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.android_course.databinding.ActivityAacBinding

class AacActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAacBinding

    private lateinit var sphericalPermanentConnectionListener: SphericalPermanentConnectionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAacBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.title.text = "LOL KEK TITLE"
        sphericalPermanentConnectionListener = SphericalPermanentConnectionListener(lifecycle = lifecycle) {
            // do something
        }

        lifecycle.addObserver(sphericalPermanentConnectionListener)
    }
}