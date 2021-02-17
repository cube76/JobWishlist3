package com.apps.jobwishlist3.di

import com.apps.jobwishlist3.core.domain.usecase.JobInteractor
import com.apps.jobwishlist3.core.domain.usecase.JobUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideJobUseCase(jobInteractor: JobInteractor): JobUseCase

}
