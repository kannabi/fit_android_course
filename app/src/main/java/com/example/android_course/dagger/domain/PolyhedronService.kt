package com.example.android_course.dagger.domain

import javax.inject.Inject

class PolyhedronService @Inject constructor(
    private val localDatasource: PolyhedronLocalDatasource,
    private val remoteDatasource: PolyhedronRemoteDatasource
) {
}