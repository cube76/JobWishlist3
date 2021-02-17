package com.apps.jobwishlist3.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps.jobwishlist3.core.data.source.local.entity.JobEntity
import com.apps.jobwishlist3.core.data.source.local.room.JobDao

@Database(entities = [JobEntity::class], version = 1, exportSchema = false)
abstract class JobDatabase : RoomDatabase() {

    abstract fun jobDao(): JobDao

}