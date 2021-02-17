package com.apps.jobwishlist3.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    val id: String,
    val title: String,
    val company: String,
    val location: String,
    val description: String,
    val type: String,
    val url: String,
    val company_logo: String?,
    val how_to_apply: String,
    val isFavorite: Boolean
) : Parcelable