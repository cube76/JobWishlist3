package com.apps.jobwishlist3.fulltime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.jobwishlist3.core.domain.usecase.JobUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val jobUseCase: JobUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FullTimeViewModel::class.java) -> {
                FullTimeViewModel(jobUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}