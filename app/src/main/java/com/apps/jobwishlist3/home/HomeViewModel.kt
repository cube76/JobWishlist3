package com.apps.jobwishlist3.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.apps.jobwishlist3.core.domain.usecase.JobUseCase

class HomeViewModel @ViewModelInject constructor(jobUseCase: JobUseCase) : ViewModel() {
    val job = jobUseCase.getAllJob().asLiveData()
}