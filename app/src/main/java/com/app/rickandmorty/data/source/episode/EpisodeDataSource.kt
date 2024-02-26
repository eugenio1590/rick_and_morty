package com.app.rickandmorty.data.source.episode

import android.content.Context
import com.app.rickandmorty.data.mapper.EpisodeMapper
import com.app.rickandmorty.domain.exception.Error
import com.app.rickandmorty.domain.model.Episode
import com.app.rickandmorty.domain.repository.EpisodeRepository
import com.app.rickandmorty.util.isConnected

/**
 * Implementation of [EpisodeRepository] that retrieves episode data from a remote service.
 *
 * @param context The instance used for Android-related operations.
 * @param mapper The mapper responsible for converting data transfer objects (DTOs) to domain entities.
 * @param service The service providing access to the remote data.
 */
class EpisodeDataSource(
    private val context: Context,
    private val mapper: EpisodeMapper,
    private val service: EpisodeService
) : EpisodeRepository {
    override suspend fun find(page: Int, limit: Int): List<Episode> {
        val response = service.getEpisodeList(page = page)
        when {
            response.isSuccessful -> return response.body()?.map(mapper::toEntity) ?: emptyList()
            !context.isConnected() -> throw Error.NetworkError.NoInternetConnection
            response.code() == 503 -> throw Error.NetworkError.ServiceUnavailable
            else -> return emptyList()
        }
    }
}
