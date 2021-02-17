package com.apps.jobwishlist3.fulltime

import android.content.Context
import com.apps.jobwishlist3.di.FullTimeModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FullTimeModuleDependencies::class])
interface FullTimeComponent {

    fun inject(activity: FullTimeActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(fullTimeModuleDependencies: FullTimeModuleDependencies): Builder
        fun build(): FullTimeComponent
    }

}