package com.apps.jobwishlist3.description

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.apps.jobwishlist3.core.domain.model.Job
import com.apps.jobwishlist3.core.domain.usecase.JobUseCase

class DescriptionViewModel @ViewModelInject constructor(private val jobUseCase: JobUseCase) : ViewModel() {
    fun setWishlistJob(job: Job, newStatus:Boolean) =
        jobUseCase.setWishlistJob(job, newStatus)
}