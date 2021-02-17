package com.apps.jobwishlist3.fulltime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.apps.jobwishlist3.core.domain.usecase.JobUseCase

class FullTimeViewModel(jobUseCase: JobUseCase) : ViewModel() {
    val job = jobUseCase.getAllFullTime().asLiveData()
}