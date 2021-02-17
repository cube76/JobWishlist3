package com.apps.jobwishlist3.di

import com.apps.jobwishlist3.core.domain.usecase.JobUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface FullTimeModuleDependencies {

    fun jobUseCase(): JobUseCase
}