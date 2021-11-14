package com.example.android_course.dagger.tetra

import com.example.android_course.dagger.di.FlowScope
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FlowScope
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
    @FlowScope
    @Provides
    fun provideTetraPresenter(): TetraPresenter = TetraPresenter()
}