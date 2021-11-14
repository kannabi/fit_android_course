package com.example.android_course.dagger.domain

class PolyhedronRemoteDatasource {
    var wasInitialized = false
    fun prettyComplexInitialize(notAMeaninglessParameterAtAll: Any) {
        wasInitialized = true
    }
}