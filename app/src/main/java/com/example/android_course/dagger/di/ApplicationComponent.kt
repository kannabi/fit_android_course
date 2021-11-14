package com.example.android_course.dagger.di

import com.example.android_course.dagger.PolyhedronActivity
import com.example.android_course.dagger.tetra.TetraComponent
import com.example.android_course.dagger.tetra.TetraSubcomponentModule
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        TetraSubcomponentModule::class,
        ViewModelBuilderModule::class
    ]
)
interface ApplicationComponent {
    fun inject(activity: PolyhedronActivity)

    fun tetraComponent(): TetraComponent.Factory
}

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FlowScope