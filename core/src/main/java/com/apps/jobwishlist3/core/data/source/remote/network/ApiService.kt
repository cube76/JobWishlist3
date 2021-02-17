package com.apps.jobwishlist3.core.data.source.remote.network

import com.apps.jobwishlist3.core.data.Resource
import com.apps.jobwishlist3.core.data.source.remote.response.JobResponse
import com.apps.jobwishlist3.core.domain.model.Job
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("positions.json")
    suspend fun getList(): List<JobResponse>

    @GET("positions.json?full_time=true")
    suspend fun getListFullTime(): List<JobResponse>

    @GET("positions.json?")
    suspend fun getSearch(@Query("description") description: String?, @Query("description") full_time: Boolean?,@Query("location") location: String?): Flow<Resource<List<Job>>>
}
