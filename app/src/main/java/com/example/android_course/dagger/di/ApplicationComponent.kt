package com.example.android_course.dagger.di

import android.content.Context
import com.example.android_course.dagger.PolyhedronActivity
import com.example.android_course.dagger.tetra.TetraComponent
import com.example.android_course.dagger.tetra.TetraSubcomponentModule
import dagger.BindsInstance
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

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun inject(activity: PolyhedronActivity)

    fun tetraComponent(): TetraComponent.Factory
}

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FlowScope