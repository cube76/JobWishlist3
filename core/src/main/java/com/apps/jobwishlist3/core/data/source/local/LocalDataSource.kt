package com.apps.jobwishlist3.core.data.source.local

import com.apps.jobwishlist3.core.data.source.local.entity.JobEntity
import com.apps.jobwishlist3.core.data.source.local.room.JobDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class LocalDataSource @Inject constructor(private val jobDao: JobDao) {

    fun getAllJob(): Flow<List<JobEntity>> = jobDao.getAllJob()

    fun getSearchJob(): Flow<List<JobEntity>> = jobDao.getSearchJob()

    fun getFavoriteJob(): Flow<List<JobEntity>> = jobDao.getFavoriteJob()

    suspend fun insertJob(jobList: List<JobEntity>) = jobDao.insertJob(jobList)

    fun setWishlistJob(job: JobEntity, newState: Boolean) {
        job.isFavorite = newState
        jobDao.updateWishlistJob(job)
    }
}