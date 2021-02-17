package com.apps.jobwishlist3.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class JobResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("company")
    val company: String,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("how_to_apply")
    val how_to_apply: String,

    @field:SerializedName("company_logo")
    val company_logo: String
)

