package com.apps.jobwishlist3.core.domain.usecase

import com.apps.jobwishlist3.core.data.Resource
import com.apps.jobwishlist3.core.domain.model.Job
import com.apps.jobwishlist3.core.domain.repository.IJobRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JobInteractor @Inject constructor(private val jobRepository: IJobRepository): JobUseCase {

    override fun getAllJob() = jobRepository.getAllJob()

    override fun getAllFullTime() = jobRepository.getAllJobFullTime()

    override fun getWishlistJob(): Flow<List<Job>> = jobRepository.getWishlistJob()

    override fun setWishlistJob(job: Job, state: Boolean) = jobRepository.setWishlistJob(job, state)
}