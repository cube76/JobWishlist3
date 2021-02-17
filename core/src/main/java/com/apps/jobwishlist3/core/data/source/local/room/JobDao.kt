package com.apps.jobwishlist3.core.data.source.local.room

import androidx.room.*
import com.apps.jobwishlist3.core.data.source.local.entity.JobEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JobDao {

    @Query("SELECT * FROM job")
    fun getAllJob(): Flow<List<JobEntity>>

    @Query("SELECT * FROM job")
    fun getSearchJob(): Flow<List<JobEntity>>

    @Query("SELECT * FROM job where isFavorite = 1")
    fun getFavoriteJob(): Flow<List<JobEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJob(tourism: List<JobEntity>)

    @Update
    fun updateWishlistJob(tourism: JobEntity)
}
