package com.example.android_course.aac

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.android_course.databinding.ActivityAacBinding

class AacActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAacBinding
    private val sphericalViewModel: SphericalViewModel by viewModels {
        SavedStateViewModelFactory(application, this)
    }

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

        sphericalViewModel.state.observe(this) {
            binding.title.text = it.toString()
        }

        binding.lolKekButton.setOnClickListener {
            sphericalViewModel.onLolKek()
        }

        binding.clearButton.setOnClickListener {
            sphericalViewModel.onClear()
        }

        binding.finishButton.setOnClickListener {
            finish()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return super.onRetainCustomNonConfigurationInstance()
    }
}