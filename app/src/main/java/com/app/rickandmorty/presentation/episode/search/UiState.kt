package com.app.rickandmorty.presentation.episode.search

/**
 * Data class representing the UI state for a paginated episode set in the application.
 *
 * @param page The current page of the data set. Nullable if not applicable.
 * @param loadState The current load state indicating the status of data loading.
 */
data class UiState(
    val page: Int? = null,
    val loadState: LoadState = LoadState.Initial
)
