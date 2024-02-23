package com.app.rickandmorty.presentation.episode.search

/**
 * Sealed class representing different user intents for the episode screen.
 */
sealed interface ViewIntent {
    /**
     * Intent to load the initial page of episodes.
     */
    data object LoadEpisodes : ViewIntent

    /**
     * Intent to load the next page of episodes when reaching the end of the list.
     */
    data object LoadMoreEpisodes : ViewIntent

    /**
     * Intent to refresh the entire list of episodes.
     */
    data object RefreshEpisodes : ViewIntent
}
