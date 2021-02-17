package com.apps.jobwishlist3.core.di

import android.content.Context
import androidx.room.Room
import com.apps.jobwishlist3.core.data.source.local.room.JobDao
import com.apps.jobwishlist3.core.data.source.local.room.JobDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): JobDatabase = Room.databaseBuilder(
        context,
        JobDatabase::class.java, "job.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideJobDao(database: JobDatabase): JobDao = database.jobDao()
}