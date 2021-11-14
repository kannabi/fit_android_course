package com.example.android_course.dagger.domain

import android.content.Context

class PolyhedronRemoteDatasource {
    private var wasInitialized = false
    private lateinit var context: Context
    fun prettyComplexInitialize(notAMeaninglessParameterAtAll: Any, context: Context) {
        this.context = context
        wasInitialized = true
    }
}