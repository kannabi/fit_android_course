package com.example.android_course.dagger.domain

import javax.inject.Inject

class PolyhedronRemoteDatasource @Inject constructor() {
    var wasInitialized = false
    fun prettyComplexInitialize(notAMeaninglessParameterAtAll: Any) {
        wasInitialized = true
    }
}