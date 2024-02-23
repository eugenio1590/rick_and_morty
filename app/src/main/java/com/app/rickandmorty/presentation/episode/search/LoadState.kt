package com.app.rickandmorty.presentation.episode.search

import com.app.rickandmorty.domain.model.Episode

/**
 * Sealed interface representing the various states of loading for a paginated episode list.
 */
sealed interface LoadState {

    /**
     * Initial state indicating that the data is not loaded yet.
     */
    data object Initial : LoadState

    /**
     * Loading state indicating that data is currently being fetched.
     */
    data object Loading : LoadState

    /**
     * Success state indicating that the data has been successfully loaded.
     *
     * @param episodes The list of episodes loaded successfully.
     */
    data class Success(val episodes: List<Episode>) : LoadState

    /**
     * Failure state indicating that an error occurred while loading the data.
     *
     * @param error The exception representing the loading failure.
     */
    data class Failure(val error: Exception) : LoadState
}
