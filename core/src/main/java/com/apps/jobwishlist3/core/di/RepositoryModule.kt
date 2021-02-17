package com.apps.jobwishlist3.core.di

import com.apps.jobwishlist3.core.data.JobRepository
import com.apps.jobwishlist3.core.domain.repository.IJobRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(jobRepository: JobRepository): IJobRepository

}