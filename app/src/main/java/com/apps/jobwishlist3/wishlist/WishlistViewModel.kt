package com.apps.jobwishlist3.wishlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.apps.jobwishlist3.core.domain.usecase.JobUseCase

class WishlistViewModel @ViewModelInject constructor(jobUseCase: JobUseCase) : ViewModel() {
    val wishlistJob = jobUseCase.getWishlistJob().asLiveData()
}