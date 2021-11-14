package com.example.android_course.dagger.tetra

import androidx.lifecycle.ViewModel
import com.example.android_course.dagger.di.FlowScope
import com.example.android_course.dagger.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@FlowScope
@Subcomponent(modules = [TetraModule::class, ViewModelBinds::class])
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

@Module
interface ViewModelBinds {
    @Binds
    @IntoMap
    @ViewModelKey(TetraViewModel::class)
    fun bindTetraViewModel(vm: TetraViewModel): ViewModel
}