package com.app.rickandmorty.presentation.episode.search

import androidx.lifecycle.viewModelScope
import com.app.rickandmorty.config.Constants.FIRST_PAGE
import com.app.rickandmorty.config.Constants.PAGE_SIZE
import com.app.rickandmorty.domain.interactor.episode.SearchEpisodes
import com.app.rickandmorty.domain.model.Episode
import com.app.rickandmorty.presentation.ErrorConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.annotations.TestOnly
import javax.inject.Inject

/**
 * ViewModel for managing the UI state and logic related to episode search.
 *
 * @param searchEpisodes The use case responsible for searching episodes.
 */
@HiltViewModel
class ViewModel @Inject constructor(
    private val searchEpisodes: SearchEpisodes,
    private val errorConverter: ErrorConverter
) : androidx.lifecycle.ViewModel() {

    @TestOnly
    constructor(searchEpisodes: SearchEpisodes) : this(searchEpisodes, ErrorConverter())

    private val _uiState = MutableStateFlow(UiState())

    // Exposes the UI state as a read-only flow to observe changes
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    /**
     * Handles the given [intent] to trigger corresponding actions.
     *
     * @param intent The view intent representing user actions or events.
     *
     * @see ViewIntent
     */
    fun handle(intent: ViewIntent): Unit? = when(intent) {
        is ViewIntent.LoadEpisodes -> fetchEpisodes(FIRST_PAGE)
        is ViewIntent.LoadMoreEpisodes -> {
            // If there are more elements to load, fetch the next page
            uiState.value.page?.let { page -> fetchEpisodes(page + 1) }
        }
        is ViewIntent.RefreshEpisodes -> fetchEpisodes(FIRST_PAGE)
    }

    private fun fetchEpisodes(page: Int, state: UiState = uiState.value) {
        update(state.copy(loadState = LoadState.Loading))
        viewModelScope.launch {
            try {
                val results = searchEpisodes(page = page, limit = PAGE_SIZE)

                val episodes: List<Episode> = when {
                    page == FIRST_PAGE -> results
                    state.loadState is LoadState.Success -> state.loadState.episodes + results
                    else -> results
                }

                val currentPage = if (results.isEmpty()) null else page

                update(state.copy(page = currentPage, loadState = LoadState.Success(episodes)))
            } catch (e: Exception) {
                val message = errorConverter.convert(e)
                update(state.copy(page = page - 1, loadState = LoadState.Failure(message = message)))
            }
        }
    }

    @TestOnly
    fun update(uiState: UiState) {
        _uiState.value = uiState
    }
}
