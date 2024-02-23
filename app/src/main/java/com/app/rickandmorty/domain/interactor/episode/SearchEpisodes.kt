package com.app.rickandmorty.domain.interactor.episode

import com.app.rickandmorty.domain.model.Episode
import java.lang.Exception

/**
 * Interface for searching and retrieving episodes.
 *
 * This interface defines a contract for searching episodes based on pagination parameters.
 * Implementing classes are responsible for providing the actual implementation for episode search.
 *
 * @see Episode
 */
interface SearchEpisodes {

    /**
     * Invokes the search operation to retrieve a paginated list of episodes.
     *
     * @param page The page number indicating the set of episodes to retrieve.
     * @param limit The maximum number of episodes to retrieve per page.
     *
     * @return A [List] of [Episode] objects representing the search results for the specified page.
     *
     * @throws Exception If there is an error during the search operation.
     */
    suspend operator fun invoke(page: Int, limit: Int): List<Episode>
}
