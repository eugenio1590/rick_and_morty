package com.app.rickandmorty.data.source.episode

import com.app.rickandmorty.data.mapper.EpisodeMapper
import com.app.rickandmorty.domain.model.Episode
import com.app.rickandmorty.domain.repository.EpisodeRepository

/**
 * Implementation of [EpisodeRepository] that retrieves episode data from a remote service.
 *
 * @param mapper The mapper responsible for converting data transfer objects (DTOs) to domain entities.
 * @param service The service providing access to the remote data.
 */
class EpisodeDataSource(
    private val mapper: EpisodeMapper,
    private val service: EpisodeService
) : EpisodeRepository {
    override suspend fun find(page: Int, limit: Int): List<Episode> {
        val result = service.getEpisodeList(page = page)
        val pagedList = result.body() ?: emptyList()
        return pagedList.map { mapper.toEntity(it) }
    }
}
