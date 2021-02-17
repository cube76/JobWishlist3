package com.apps.jobwishlist3.core.domain.usecase

import com.apps.jobwishlist3.core.data.Resource
import com.apps.jobwishlist3.core.domain.model.Job
import kotlinx.coroutines.flow.Flow

interface JobUseCase {
    fun getAllJob(): Flow<Resource<List<Job>>>
    fun getAllFullTime(): Flow<Resource<List<Job>>>
    fun getWishlistJob(): Flow<List<Job>>
    fun setWishlistJob(job: Job, state: Boolean)
}