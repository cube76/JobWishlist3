package com.apps.jobwishlist3.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "job")
data class JobEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "company")
        var company: String,

        @ColumnInfo(name = "location")
        var location: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "type")
        var type: String,

        @ColumnInfo(name = "url")
        var url: String,

        @ColumnInfo(name = "company_logo")
        var company_logo: String?,

        @ColumnInfo(name = "how_to_apply")
        var how_to_apply: String,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean = false
)
