package com.apps.jobwishlist3.core.utils

import com.apps.jobwishlist3.core.data.source.local.entity.JobEntity
import com.apps.jobwishlist3.core.data.source.remote.response.JobResponse
import com.apps.jobwishlist3.core.domain.model.Job

object DataMapper {
    fun mapResponsesToEntities(input: List<JobResponse>): List<JobEntity> {
        val tourismList = ArrayList<JobEntity>()
        input.map {
            val tourism = JobEntity(
                id = it.id,
                title = it.title,
                company = it.company,
                location = it.location,
                description = it.description,
                type = it.type,
                url = it.url,
                company_logo = it.company_logo,
                how_to_apply = it.how_to_apply,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<JobEntity>): List<Job> =
        input.map {
            Job(
                id = it.id,
                title = it.title,
                company = it.company,
                location = it.location,
                description = it.description,
                type = it.type,
                url = it.url,
                company_logo = it.company_logo,
                how_to_apply = it.how_to_apply,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Job) = JobEntity(
        id = input.id,
        title = input.title,
        company = input.company,
        location = input.location,
        description = input.description,
        type = input.type,
        url = input.url,
        company_logo = input.company_logo,
        how_to_apply = input.how_to_apply,
        isFavorite = input.isFavorite
    )
}