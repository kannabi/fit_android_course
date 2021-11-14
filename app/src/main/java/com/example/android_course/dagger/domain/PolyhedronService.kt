package com.example.android_course.dagger.domain

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PolyhedronService @Inject constructor(
    private val localDatasource: PolyhedronLocalDatasource,
    private val remoteDatasource: PolyhedronRemoteDatasource
) {
}