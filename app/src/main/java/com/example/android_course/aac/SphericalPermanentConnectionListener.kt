package com.example.android_course.aac

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class SphericalPermanentConnectionListener(
    private val service: SphericalPermanentConnectionService = SphericalPermanentConnectionService(),
    private val lifecycle: Lifecycle,
    private val onUpdate: (SphericalData) -> Unit
) : DefaultLifecycleObserver {

    init {
        service.registerListener {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                onUpdate(it)
            }
        }
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("SPCL", "onStart")
        service.connect()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("SPCL", "onStop")
        service.disconnect()
    }
}