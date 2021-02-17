package com.apps.jobwishlist3.core.data

import com.apps.jobwishlist3.core.data.source.local.LocalDataSource
import com.apps.jobwishlist3.core.data.source.remote.RemoteDataSource
import com.apps.jobwishlist3.core.data.source.remote.network.ApiResponse
import com.apps.jobwishlist3.core.data.source.remote.response.JobResponse
import com.apps.jobwishlist3.core.domain.model.Job
import com.apps.jobwishlist3.core.domain.repository.IJobRepository
import com.apps.jobwishlist3.core.utils.AppExecutors
import com.apps.jobwishlist3.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

class JobRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IJobRepository {

    override fun getAllJob(): Flow<Resource<List<Job>>> =
        object : NetworkBoundResource<List<Job>, List<JobResponse>>() {
            override fun loadFromDB(): Flow<List<Job>> {
                return localDataSource.getAllJob().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Job>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<JobResponse>>> =
                remoteDataSource.getAllJob()

            override suspend fun saveCallResult(data: List<JobResponse>) {
                val jobList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertJob(jobList)
            }
        }.asFlow()

    override fun getAllJobFullTime(): Flow<Resource<List<Job>>> =
        object : NetworkBoundResource<List<Job>, List<JobResponse>>() {
            override fun loadFromDB(): Flow<List<Job>> {
                return localDataSource.getAllJob().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Job>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<JobResponse>>> =
                remoteDataSource.getListFullTime()

            override suspend fun saveCallResult(data: List<JobResponse>) {
                val jobList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertJob(jobList)
            }
        }.asFlow()

    override fun getWishlistJob(): Flow<List<Job>> {
        return localDataSource.getFavoriteJob().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setWishlistJob(job: Job, state: Boolean) {
        val jobEntity = DataMapper.mapDomainToEntity(job)
        appExecutors.diskIO().execute { localDataSource.setWishlistJob(jobEntity, state) }
    }
}

