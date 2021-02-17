package com.apps.jobwishlist3.core.domain.repository

import com.apps.jobwishlist3.core.data.Resource
import com.apps.jobwishlist3.core.domain.model.Job
import kotlinx.coroutines.flow.Flow

interface IJobRepository {

    fun getAllJob(): Flow<Resource<List<Job>>>

    fun getAllJobFullTime(): Flow<Resource<List<Job>>>

    fun getWishlistJob(): Flow<List<Job>>

    fun setWishlistJob(job: Job, state: Boolean)

}