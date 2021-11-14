package com.example.android_course.dagger.di

import android.content.Context
import com.example.android_course.dagger.domain.PolyhedronRemoteDatasource
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideRemoteDatasource(context: Context): PolyhedronRemoteDatasource {
        return PolyhedronRemoteDatasource()
            .apply { prettyComplexInitialize(Any(), context) }
    }
}