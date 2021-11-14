package com.example.android_course.dagger.di

import com.example.android_course.dagger.domain.DatabasePolyhedronLocalDatasource
import com.example.android_course.dagger.domain.PolyhedronLocalDatasource
import dagger.Binds
import dagger.Module

@Module
interface DatabaseModule {
    @Binds
    fun bindLocalDatastore(impl: DatabasePolyhedronLocalDatasource): PolyhedronLocalDatasource
}