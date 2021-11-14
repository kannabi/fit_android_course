package com.example.android_course.dagger.di

import com.example.android_course.dagger.domain.PolyhedronRemoteDatasource
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideRemoteDatasource(): PolyhedronRemoteDatasource {
        return PolyhedronRemoteDatasource()
            .apply { prettyComplexInitialize(Any()) }
    }
}