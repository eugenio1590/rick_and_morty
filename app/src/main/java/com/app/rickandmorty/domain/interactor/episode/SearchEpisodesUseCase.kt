package com.app.rickandmorty.domain.interactor.episode

import com.app.rickandmorty.domain.model.Episode
import com.app.rickandmorty.domain.repository.EpisodeRepository

/**
 * Use case for searching and retrieving episodes.
 *
 * This internal class implements the [SearchEpisodes] interface, providing a higher-level abstraction
 * for searching episodes. It delegates the actual search operation to the [EpisodeRepository].
 *
 * @param episodeRepository The repository responsible for fetching episodes from a data source.
 */
internal class SearchEpisodesUseCase(
    private val episodeRepository: EpisodeRepository
) : SearchEpisodes {
    override suspend fun invoke(page: Int, limit: Int): List<Episode> {
        return episodeRepository.find(page = page, limit = limit)
    }
}
