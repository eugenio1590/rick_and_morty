package com.app.rickandmorty.domain.repository

import com.app.rickandmorty.domain.model.Episode

/**
 * Repository interface for retrieving episodes.
 *
 * This interface defines a contract for fetching episodes from a data source.
 */
interface EpisodeRepository {

    /**
     * Find and retrieve a paginated list of episodes.
     *
     * @param page The page number indicating the set of episodes to retrieve.
     * @param limit The maximum number of episodes to retrieve per page.
     *
     * @return A [List] of [Episode] objects representing the search results for the specified page.
     *
     * @throws Exception If there is an error during the retrieval operation.
     */
    suspend fun find(page: Int, limit: Int): List<Episode>
}
