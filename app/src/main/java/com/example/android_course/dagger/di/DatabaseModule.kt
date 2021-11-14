package com.example.android_course.dagger.di

import com.example.android_course.dagger.domain.DatabasePolyhedronLocalDatasource
import com.example.android_course.dagger.domain.PolyhedronLocalDatasource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DatabaseModule {
    @Singleton
    @Binds
    fun bindLocalDatastore(impl: DatabasePolyhedronLocalDatasource): PolyhedronLocalDatasource
}