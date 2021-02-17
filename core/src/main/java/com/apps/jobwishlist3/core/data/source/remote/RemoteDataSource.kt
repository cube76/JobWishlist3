package com.apps.jobwishlist3.core.data.source.remote

import android.util.Log
import com.apps.jobwishlist3.core.data.source.remote.network.ApiResponse
import com.apps.jobwishlist3.core.data.source.remote.network.ApiService
import com.apps.jobwishlist3.core.data.source.remote.response.JobResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllJob(): Flow<ApiResponse<List<JobResponse>>> {
        //get data from remote api
        return flow {
            try {
                val dataArray = apiService.getList()
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getListFullTime(): Flow<ApiResponse<List<JobResponse>>> {
        //get data from remote api
        return flow {
            try {
                val dataArray = apiService.getListFullTime()
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

//    suspend fun getSearchJob(description: String,full_time: Boolean,location: String): Flow<ApiResponse<List<JobResponse>>> {
//        //get data from remote api
//        return flow {
//            try {
//                val dataArray = apiService.getSearch(description, full_time, location)
//                if (dataArray.isNotEmpty()){
//                    emit(ApiResponse.Success(dataArray))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e : Exception){
//                emit(ApiResponse.Error(e.toString()))
//                Log.e("RemoteDataSource", e.toString())
//            }
//        }.flowOn(Dispatchers.IO)
//    }
}

