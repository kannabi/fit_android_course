package com.example.android_course.aac

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryOwner

class SphericalPermanentConnectionListener(
    private val service: SphericalPermanentConnectionService = SphericalPermanentConnectionService(),
    private val lifecycle: Lifecycle,
    private val registryOwner: SavedStateRegistryOwner,
    private val onUpdate: (SphericalData) -> Unit
) : DefaultLifecycleObserver, SavedStateRegistry.SavedStateProvider {

    private var sphericalId: Int = -1

    init {
        service.registerListener {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                onUpdate(it)
            }
        }

        registryOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_CREATE) {
                val savedStateRegistry = registryOwner.savedStateRegistry
                savedStateRegistry.registerSavedStateProvider(
                    PERMANENT_CONNECTION_SAVED_STATE_KEY, this
                )
                savedStateRegistry.consumeRestoredStateForKey(PERMANENT_CONNECTION_SAVED_STATE_KEY)
                    ?.getInt(SPHERICAL_ID_KEY)
                    ?.let(::sphericalId::set)
            }
        })
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

    override fun saveState(): Bundle =
//        bundleOf(SPHERICAL_ID_KEY to sphericalId)
        bundleOf(SPHERICAL_ID_KEY to 0)

    companion object {
        private const val PERMANENT_CONNECTION_SAVED_STATE_KEY =
            "PERMANENT_CONNECTION_SAVED_STATE_KEY"

        private const val SPHERICAL_ID_KEY = "SPHERICAL_ID_KEY"
    }
}