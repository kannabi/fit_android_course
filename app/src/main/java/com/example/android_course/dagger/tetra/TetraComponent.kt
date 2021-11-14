package com.example.android_course.dagger.tetra

import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [TetraModule::class])
interface TetraComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): TetraComponent
    }

    fun inject(activity: TetrahedronActivity)
    fun inject(fragment: TetraFirstFragment)
    fun inject(fragment: TetraSecondFragment)
}

@Module(subcomponents = [TetraComponent::class])
class TetraSubcomponentModule

@Module
class TetraModule {
    @Provides
    fun provideTetraPresenter(): TetraPresenter = TetraPresenter()
}