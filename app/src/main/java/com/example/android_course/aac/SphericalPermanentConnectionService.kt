package com.example.android_course.aac

class SphericalPermanentConnectionService {
    fun registerListener(onUpdate: (SphericalData) -> Unit) {
        // register
    }

    fun connect() {
        // connect
    }

    fun disconnect() {
        // disconnect
    }
}

data class SphericalData(val id: String)